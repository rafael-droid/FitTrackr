package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.workout.FitTrackr.Model.Note;

public interface NoteRepository extends JpaRepository<Long, Note> {
}
