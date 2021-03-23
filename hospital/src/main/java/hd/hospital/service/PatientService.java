package hd.hospital.service;

import hd.hospital.domain.Patient;
import hd.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void save(Patient patient){
        patientRepository.save(patient);
    }

    public List<Patient> findAll(){
        return patientRepository.findAll();
    }

    public Optional<Patient> findById(Long id){
        return patientRepository.findById(id);
    }

    public void update(Patient patient){
        patientRepository.update(patient);
    }

    public void deleteById(Long id){
        patientRepository.deleteById(id);
    }
}
