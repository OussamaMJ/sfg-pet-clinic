package enadev.spring.sfgpetclinic.repositories.reactive;

import enadev.spring.sfgpetclinic.model.Vet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VetReactiveRepository extends ReactiveMongoRepository<Vet, String> {
}
