package hd.hospital.service;

import hd.hospital.domain.Hospital;
import hd.hospital.domain.Patient;
import hd.hospital.repository.PatientRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PatientServiceTest {

    @Autowired private PatientService patientService;
    @Autowired private PatientRepository patientRepository;

    @Test
    public void save(){
        Hospital hospital = new Hospital("hospital", "10", "chief");
        Patient patient = new Patient(hospital, "patient", "10", "M", "2021-03-22","010-1234-5678");
        patientRepository.save(patient);
        System.out.println(patient.getHospital());
        Assertions.assertThat(patient.getPatientName()).isEqualTo(patientService.findById(1L).get().getPatientName());
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