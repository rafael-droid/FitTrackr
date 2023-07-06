package pl.workout.FitTrackr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.workout.FitTrackr.Model.MedicalInfo;

@Repository
public interface MedicalInfoRepository extends JpaRepository<MedicalInfo, Long> {

    MedicalInfo findByUserId(Long userId);
}
