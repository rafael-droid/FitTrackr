package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.workout.FitTrackr.Model.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
}
