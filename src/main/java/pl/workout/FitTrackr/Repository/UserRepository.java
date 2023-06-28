package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.workout.FitTrackr.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
