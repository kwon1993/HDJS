package hd.hospital.repository;

import hd.hospital.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Modifying
    @Query(value = "update Visit v " +
            "set v.hospital = hospital, v.patient = patient, v.reception_date = reception_date, v.status_code = status_code " +
            "where v.id = id", nativeQuery = true)
    void update(@Param("visit") Visit visit);

}
