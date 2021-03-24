package hd.hospital.service;

import hd.hospital.domain.Patient;
import hd.hospital.predicate.PatientPredicate;
import hd.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
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

    private int sequence;

    public void save(Patient patient) {
        patient.setRegistrationNumber(patientRegistrationNumberGenerator());
        patientRepository.save(patient);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public Page<Patient> search(Patient patient, Pageable pageable) {
        return patientRepository
                .findAll(PatientPredicate.search(patient.getPatientName(), patient.getRegistrationNumber(), patient.getBirth()), pageable);
    }

    public void update(Patient patient) {
        patientRepository.update(patient);
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    private String patientRegistrationNumberGenerator() { //환자 등록 번호 생성기
        //현제 년도 가져옴 -> DB 최근 테이블 하나 가져옴 -> 년도 같으면 sequence + 1 아니거나 null 이면 sequence = 1
        Calendar calendar = Calendar.getInstance();
        int intYear = calendar.get(Calendar.YEAR); //현재 년도값 가져오기
        String year = Integer.toString(intYear);
        String latestRegistrationNumber = patientRepository.latestRegistrationNumber(); //최근에 들어간 등록번호
        if (latestRegistrationNumber == null || latestRegistrationNumber.isEmpty()) { //sequence 값 설정
            sequence = 1;
        } else if (!latestRegistrationNumber.substring(0, 4).equals(year)) {
            sequence = 1;
        } else {
            sequence = Integer.parseInt(latestRegistrationNumber.substring(4)) + 1;
        }
        String result = year + String.format("%05d", sequence);
        return result;
    }
}
