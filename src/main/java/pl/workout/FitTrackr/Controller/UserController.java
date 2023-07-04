package pl.workout.FitTrackr.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.workout.FitTrackr.Model.User;
import pl.workout.FitTrackr.Service.UserService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id).orElseThrow();
    }
}
