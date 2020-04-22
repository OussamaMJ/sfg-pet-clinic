package enadev.spring.sfgpetclinic.repositories.reactive;

import enadev.spring.sfgpetclinic.model.Pet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PetReactiveRepository extends ReactiveMongoRepository<Pet, String> {
}
