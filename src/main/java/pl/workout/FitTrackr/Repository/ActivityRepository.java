package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.workout.FitTrackr.Model.Activity;

public interface ActivityRepository extends JpaRepository<Long, Activity> {
}
