package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.workout.FitTrackr.Model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u FROM user u WHere u.lastName = :lastName")
    User getUserByLastName(@Param("lastName") String lastName);

    @Query("select u FROM user u WHere u.firstName = :firstName")
    User getUserByFirstName(@Param("firstName") String firstName);

    User findByEmail(String email);
}
