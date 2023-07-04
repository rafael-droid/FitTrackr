package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.workout.FitTrackr.Model.Activity;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Activity findAllById(Long id);

    Optional<Activity> findByIdAndUserId(Long id, Long userId);
    List<Activity> findByUserId(Long userId);

}
