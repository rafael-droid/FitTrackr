package pl.workout.FitTrackr.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.FitTrackr.Model.User;
import pl.workout.FitTrackr.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    public final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User editUser(User user) {
        User userDb = userRepository.findById(user.getId()).orElseThrow();

        userDb.setFirstName(user.getFirstName());
        userDb.setLastName(user.getLastName());
        userDb.setPassword(user.getPassword());
        userDb.setEmail(user.getEmail());
        userDb.setDateOfBirth(user.getDateOfBirth());

        return userDb;
    }
}
