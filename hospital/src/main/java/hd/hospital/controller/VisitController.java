package hd.hospital.controller;

import hd.hospital.domain.Visit;
import hd.hospital.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class VisitController {

    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @PostMapping("/visit/registration")
    public void save(Visit visit){
        visitService.save(visit);
    }

    @PostMapping("/visit/list")
    public List<Visit> findAll(){
        return visitService.findAll();
    }

    @PostMapping("/visit/search")
    public Optional<Visit> findById(Long id){
        return visitService.findById(id);
    }

    @PostMapping("/visit/update")
    public void update(Visit visit){
        visitService.update(visit);
    }

    @PostMapping("/visit/delete")
    public void deleteById(Long id){
        visitService.deleteById(id);
    }
}
