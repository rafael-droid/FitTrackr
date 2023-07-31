package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.workout.FitTrackr.Model.Activity;
import pl.workout.FitTrackr.Model.Route;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    Optional<Activity> findByIdAndUserId(Long id, Long userId);
    List<Activity> findByUserId(Long userId);
}
