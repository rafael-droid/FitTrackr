package pl.workout.FitTrackr.Security.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.workout.FitTrackr.Model.User;
import pl.workout.FitTrackr.Repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    public AuthenticationResponse register(RegisterRequest request) {

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

    }
}
