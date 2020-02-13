package enadev.spring.sfgpetclinic.repositories;

import enadev.spring.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepositories extends CrudRepository<Pet, Long> {
}
