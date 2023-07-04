package pl.workout.FitTrackr.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import pl.workout.FitTrackr.Model.Activity;
import pl.workout.FitTrackr.Repository.ActivityRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {
    @Autowired
    private final ActivityRepository activityRepository;

    public List<Activity> getActivities(Long userId){
        return activityRepository.findByUserId(userId);
    }
    public Activity getActivityById(Long id){
        return activityRepository.findAllById(id);
    }
}
