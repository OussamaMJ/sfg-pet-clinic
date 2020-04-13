package enadev.spring.sfgpetclinic.service.springdatamongo;

import enadev.spring.sfgpetclinic.model.Visit;
import enadev.spring.sfgpetclinic.repositories.VisitRepository;
import enadev.spring.sfgpetclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatamongo")
public class VisitSDMService implements VisitService {
    private final VisitRepository visitRepository;

    public VisitSDMService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(String aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(String aLong) {
        visitRepository.deleteById(aLong);
    }
}
