package pl.workout.FitTrackr.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import pl.workout.FitTrackr.Exception.ResourceNotFoundException;
import pl.workout.FitTrackr.Model.Activity;
import pl.workout.FitTrackr.Model.User;
import pl.workout.FitTrackr.Repository.ActivityRepository;
import pl.workout.FitTrackr.Repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {
    @Autowired
    private final ActivityRepository activityRepository;
    @Autowired
    private final UserRepository userRepository;

    public List<Activity> getActivities(Long userId){
        return activityRepository.findByUserId(userId);
    }
    public Activity getActivityById(Long id){
        return activityRepository.findAllById(id);
    }

    public Activity addActivity(Long userId, Activity activity) {
        User userDb = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
        activity.setUser(userDb);
        return activityRepository.save(activity);

    }

    public Activity updateActivity(Long userId, Long activityId, Activity activity) {
        User userDb = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
        Activity activityDb = activityRepository.findByIdAndUserId(activityId,userId)
                .orElseThrow(() -> new ResourceNotFoundException("ActivityId " + activityId + " not found"));

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
