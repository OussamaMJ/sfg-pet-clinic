package enadev.spring.sfgpetclinic.service.springdatamongo;

import enadev.spring.sfgpetclinic.model.PetType;
import enadev.spring.sfgpetclinic.repositories.PetTypeRepository;
import enadev.spring.sfgpetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatamongo")
public class PetTypeSDMService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeSDMService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(String aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(String aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
