package pl.workout.FitTrackr.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.FitTrackr.Exception.ResourceNotFoundException;
import pl.workout.FitTrackr.Model.MedicalInfo;
import pl.workout.FitTrackr.Model.User;
import pl.workout.FitTrackr.Repository.MedicalInfoRepository;
import pl.workout.FitTrackr.Repository.UserRepository;

@Service
@RequiredArgsConstructor
public class MedicalInfoService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final MedicalInfoRepository medicalInfoRepository;

    public MedicalInfo getMedicalInfo(Long userId) {
        return medicalInfoRepository.findByUserId(userId);
    }

    public MedicalInfo addMedicalInfo(Long userId, MedicalInfo medicalInfo) {
        User userDb = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
        medicalInfo.setUser(userDb);
        MedicalInfo medicalInfoDb = medicalInfoRepository.save(medicalInfo);

        return medicalInfoDb;

    }
}
