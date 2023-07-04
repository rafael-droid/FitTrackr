package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.workout.FitTrackr.Model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from user u left join fetch u.activity")
    List<User> findAllUsers();
}
