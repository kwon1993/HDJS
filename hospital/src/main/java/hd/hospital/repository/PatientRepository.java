package hd.hospital.repository;

import hd.hospital.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Modifying
    @Query(value = "update Patient p " +
            "set p.patientName = patientName, p.genderCode = genderCode, p.birth = birth, p.phoneNumber = phoneNumber " +
            "where p.id = id", nativeQuery = true)
    void update(@Param("patient") Patient patient);
}
