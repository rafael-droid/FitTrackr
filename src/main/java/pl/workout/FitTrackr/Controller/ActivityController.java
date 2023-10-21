package pl.workout.FitTrackr.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.workout.FitTrackr.Model.Activity;
import pl.workout.FitTrackr.Service.ActivityService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class ActivityController {
    @Autowired
    private final ActivityService activityService;

    @GetMapping("/{userId}/activity")
    @ResponseStatus(HttpStatus.OK)
    public List<Activity> getActivity(@PathVariable("userId") Long userId){
        return activityService.getActivities(userId);
    }

    @PostMapping("/{userId}/activity")
    @ResponseStatus(HttpStatus.CREATED)
    public Activity createActivity(@PathVariable("userId") Long userId, @RequestBody Activity activity) {
        return activityService.addActivity(userId, activity);
    }

    @PutMapping("/{userId}/activity/{activityId}")
    @ResponseStatus(HttpStatus.OK)
    public Activity updateActivity(@PathVariable("userId") Long userId, @PathVariable("activityId") Long activityId, @RequestBody Activity activity){
        return activityService.updateActivity(userId, activityId, activity);
    }
    @DeleteMapping("/{userId}/activity/{activityId}")
    @ResponseStatus(HttpStatus.OK)
    public int deleteActivity(@PathVariable("userId") Long userId, @PathVariable("activityId") Long activityId){
        return activityService.deleteActivity(userId, activityId);
    }
}
