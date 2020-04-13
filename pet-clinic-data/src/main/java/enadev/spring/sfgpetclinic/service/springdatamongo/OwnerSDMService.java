package enadev.spring.sfgpetclinic.service.springdatamongo;

import enadev.spring.sfgpetclinic.model.Owner;
import enadev.spring.sfgpetclinic.repositories.OwnerRepository;
import enadev.spring.sfgpetclinic.repositories.PetRepository;
import enadev.spring.sfgpetclinic.repositories.PetTypeRepository;
import enadev.spring.sfgpetclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatamongo")
public class OwnerSDMService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDMService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String anyString) {
        return ownerRepository.findAllByLastNameLike(anyString);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(String aLong) {
        Optional<Owner> owner = ownerRepository.findById(aLong);
        return owner.orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(String aLong) {
        ownerRepository.deleteById(aLong);
    }
}