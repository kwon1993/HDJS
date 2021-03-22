package hd.hospital.repository;

import hd.hospital.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface visitRepository extends JpaRepository<Visit, Long> {
}
