package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.workout.FitTrackr.Model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
