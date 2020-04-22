package enadev.spring.sfgpetclinic.repositories.reactive;

import enadev.spring.sfgpetclinic.model.Visit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VisitReactiveRepository extends ReactiveMongoRepository<Visit, String> {
}
