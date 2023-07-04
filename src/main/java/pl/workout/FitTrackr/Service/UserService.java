package pl.workout.FitTrackr.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.workout.FitTrackr.Model.User;
import pl.workout.FitTrackr.Repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAllUsers();
    }
}
