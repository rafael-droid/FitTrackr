package pl.workout.FitTrackr.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.workout.FitTrackr.Model.Activity;
import pl.workout.FitTrackr.Model.User;
import pl.workout.FitTrackr.Repository.ActivityRepository;
import pl.workout.FitTrackr.Repository.MedicalInfoRepository;
import pl.workout.FitTrackr.Repository.UserRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {
    @Autowired
    private final ActivityRepository activityRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final MedicalInfoRepository medicalInfoRepository;

    public List<Activity> getActivities(Long userId){
        return activityRepository.findByUserId(userId);
    }
    public Activity getActivityById(Long id){
        return activityRepository.findAllById(id);
    }

    public Activity addActivity(Long userId, Activity activity) {
        User userDb = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + userId + " not found"));
        int calories = 0;
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        int height = (int) medicalInfoRepository.findByUserId(userId).getHeight();
        int weight = (int) medicalInfoRepository.findByUserId(userId).getWeight();

        switch (activity.getName()){
            case RUNNING:{
                calories = (int) (weight * activity.getDistance()*0.09);
            }
            case CYCLING:{

            }
            case SWIMMING:{

            }
        }
        activity.setUser(userDb);
        activity.setCreatedAt(localDateTime.format(formatter));
        activity.setCaloriesBurned(calories);
        return activityRepository.save(activity);

    }

    public Activity updateActivity(Long userId, Long activityId, Activity activity) {
        User userDb = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + userId + " not found"));
        Activity activityDb = activityRepository.findByIdAndUserId(activityId,userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ActivityId " + activityId + " not found"));

        activityDb.setName(activity.getName());
        activityDb.setDescription(activityDb.getDescription());
        activityDb.setDuration(activityDb.getDuration());
        activityDb.setDistance(activityDb.getDistance());
        activityDb.setCaloriesBurned(activity.getCaloriesBurned());
        activityDb.setResult(activity.getResult());

        activityRepository.save(activityDb);
        return activityDb;
    }
}
