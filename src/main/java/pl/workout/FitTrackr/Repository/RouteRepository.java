package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.workout.FitTrackr.Model.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
