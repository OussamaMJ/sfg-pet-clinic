package enadev.spring.sfgpetclinic.repositories.reactive;

import enadev.spring.sfgpetclinic.model.PetType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PetTypeReactiveRepository extends ReactiveMongoRepository<PetType, String> {
}
