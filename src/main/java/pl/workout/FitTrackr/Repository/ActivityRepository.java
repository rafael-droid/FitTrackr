package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.workout.FitTrackr.Model.Activity;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Activity findAllById(Long id);


    @Query("Select a From activity a " +
            " left join fetch a.user")
    List<Activity> findAllActivities();
}
