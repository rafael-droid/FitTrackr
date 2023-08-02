package pl.workout.FitTrackr.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.workout.FitTrackr.Model.Route;
import pl.workout.FitTrackr.Model.User;
import pl.workout.FitTrackr.Repository.RouteRepository;
import pl.workout.FitTrackr.Repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {
    @Autowired
    private final RouteRepository routeRepository;
    @Autowired
    private final UserRepository userRepository;
    public List<Route> getRoutes(Long userId) {
        User userDb = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + userId + " not found"));
        return routeRepository.findByUserId(userId);
    }

    public Route addRoute(Long userId, Route route) {
        User userDb = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + userId + " not found"));
        return routeRepository.save(route);
    }

    public Route updateRoute(Long userId, Long routeId, Route route) {
        return null;
    }

    public List<Route> deleteRoute(Long userId, Long routeId) {
        User userDb = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + userId + " not found"));

        routeRepository.deleteById(routeId);
        return routeRepository.findByUserId(userId);
    }
}
