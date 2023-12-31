package pl.workout.FitTrackr.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
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
        User userDb = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + userId + " not found"));
        medicalInfo.setUser(userDb);

        return medicalInfoRepository.save(medicalInfo);

    }

    public MedicalInfo updateMedicalInfo(Long userId, Long medicalInfoId, MedicalInfo medicalInfo) {
        User userDb = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId " + userId + " not found"));
        MedicalInfo medicalInfoDb = medicalInfoRepository.findById(medicalInfoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "MedicalInfoId " + medicalInfoId + " not found"));

        medicalInfoDb.setHeight(medicalInfo.getHeight());
        medicalInfoDb.setWeight(medicalInfo.getWeight());

        medicalInfoRepository.save(medicalInfoDb);

        return medicalInfoDb;
    }
}
