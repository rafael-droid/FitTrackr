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

    //@GetMapping("/{userId}/activity/{activityId}")
   // @ResponseStatus(HttpStatus.OK)
    //public Activity getActivityById(@PathVariable("id") Long id){
        //return activityService.getActivityById(id);
   // }
}
