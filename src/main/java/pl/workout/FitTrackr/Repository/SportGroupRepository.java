package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.workout.FitTrackr.Model.SportGroup;

@Repository
public interface SportGroupRepository extends JpaRepository<SportGroup, Long> {
}
