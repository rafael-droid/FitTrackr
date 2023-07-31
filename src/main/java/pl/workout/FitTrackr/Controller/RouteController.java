package pl.workout.FitTrackr.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.workout.FitTrackr.Model.Activity;
import pl.workout.FitTrackr.Model.Route;
import pl.workout.FitTrackr.Service.ActivityService;
import pl.workout.FitTrackr.Service.RouteService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class RouteController {
    @Autowired
    private final RouteService routeService;

    @GetMapping("/{userId}/route")
    @ResponseStatus(HttpStatus.OK)
    public List<Activity> getActivity(@PathVariable("userId") Long userId){
        return routeService.getRoutes(userId);
    }

    @PostMapping("/{userId}/route")
    @ResponseStatus(HttpStatus.CREATED)
    public Activity createActivity(@PathVariable("userId") Long userId, @RequestBody Route route) {
        return routeService.addRoute(userId, route);
    }

    @PutMapping("/{userId}/route/{routeId}")
    @ResponseStatus(HttpStatus.OK)
    public Activity updateActivity(@PathVariable("userId") Long userId, @PathVariable("activityId") Long routeId, @RequestBody Route route){
        return routeService.updateRoute(userId, routeId, route);
    }
}
}
