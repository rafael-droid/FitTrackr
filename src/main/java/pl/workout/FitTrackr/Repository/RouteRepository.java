package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.workout.FitTrackr.Model.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
