package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.workout.FitTrackr.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
