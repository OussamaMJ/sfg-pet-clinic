package enadev.spring.sfgpetclinic.service.springdatamongo;

import enadev.spring.sfgpetclinic.model.Vet;
import enadev.spring.sfgpetclinic.repositories.VetRepository;
import enadev.spring.sfgpetclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatamongo")
public class VetSDMService implements VetService {
    private final VetRepository vetRepository;

    public VetSDMService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(String aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
            vetRepository.delete(object);
    }

    @Override
    public void deleteById(String aLong) {
            vetRepository.deleteById(aLong);
    }
}
