package pl.workout.FitTrackr.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.workout.FitTrackr.Model.MedicalInfo;
import pl.workout.FitTrackr.Service.MedicalInfoService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MedicalInfoController {

    private final MedicalInfoService medicalInfoService;
    @GetMapping("/{userId}/medicalInfo")
    @ResponseStatus(HttpStatus.OK)
    public MedicalInfo getMedicalInfo(@PathVariable("userId") Long userId){
        return medicalInfoService.getMedicalInfo(userId);
    }

    @PostMapping("/{userId}/medicalInfo")
    @ResponseStatus(HttpStatus.CREATED)
    public MedicalInfo createMedicalInfo(@PathVariable("userId") Long userId, @RequestBody MedicalInfo medicalInfo){
        return medicalInfoService.addMedicalInfo(userId, medicalInfo);
    }

    @PutMapping("/{userId}/medicalInfo/{medicalInfoId}")
    @ResponseStatus(HttpStatus.OK)
    public MedicalInfo updateMedicalInfo(@PathVariable("userId") Long userId, @PathVariable("medicalInfoId") Long medicalInfoId, @RequestBody MedicalInfo medicalInfo){
        return medicalInfoService.updateMedicalInfo(userId, medicalInfoId, medicalInfo);
    }
}
