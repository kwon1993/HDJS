package hd.hospital.controller;

import hd.hospital.domain.Patient;
import hd.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/patient/registration")
    public void save(Patient patient) {
        patientService.save(patient);
    }

    @PostMapping("/patient/list")
    public List<Patient> findAll() {
        return patientService.findAll();
    }

    @PostMapping("/patient/findById")
    public Optional<Patient> findById(Long id) {
        return patientService.findById(id);
    }

    @PostMapping("/patient/search")
    public Page<Patient> search(Patient patient, int pageSize, int pageNo) {
        return patientService.search(patient, pageSize, pageNo);
    }

    @PostMapping("/patient/update")
    public void update(Patient patient) {
        patientService.update(patient);
    }

    @PostMapping("/patient/delete")
    public void deleteById(Long id) {
        patientService.deleteById(id);
    }
}
