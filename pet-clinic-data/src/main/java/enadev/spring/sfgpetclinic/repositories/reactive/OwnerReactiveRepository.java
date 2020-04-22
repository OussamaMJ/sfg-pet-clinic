package enadev.spring.sfgpetclinic.repositories.reactive;

import enadev.spring.sfgpetclinic.model.Owner;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OwnerReactiveRepository extends ReactiveMongoRepository<Owner, String> {
    Mono<Owner> findByLastName(String lastName);
    Flux<Owner> findAllByLastName(String anyString);
}
