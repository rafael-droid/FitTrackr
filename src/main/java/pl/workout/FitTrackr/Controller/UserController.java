package pl.workout.FitTrackr.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.workout.FitTrackr.Model.User;
import pl.workout.FitTrackr.Service.UserService;

import java.util.List;


@RequestMapping("/user")
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
        return userService.getUserById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + id + " not found"));
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/update/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable("userId") Long userId, @RequestBody User user){
        return userService.editUser(userId, user);
    }
}
