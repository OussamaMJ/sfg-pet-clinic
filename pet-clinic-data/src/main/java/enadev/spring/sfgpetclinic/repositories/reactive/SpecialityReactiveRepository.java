package enadev.spring.sfgpetclinic.repositories.reactive;

import enadev.spring.sfgpetclinic.model.Speciality;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SpecialityReactiveRepository extends ReactiveMongoRepository<Speciality, String> {
}
