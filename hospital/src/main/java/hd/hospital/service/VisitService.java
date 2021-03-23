package hd.hospital.service;

import hd.hospital.domain.Visit;
import hd.hospital.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public void save(Visit visit){
        visitRepository.save(visit);
    }

    public List<Visit> findAll(){
        return visitRepository.findAll();
    }

    public Optional<Visit> findById(Long id){
        return visitRepository.findById(id);
    }

    public void update(Visit visit){
        visitRepository.update(visit);
    }

    public void deleteById(Long id){
        visitRepository.deleteById(id);
    }
}
