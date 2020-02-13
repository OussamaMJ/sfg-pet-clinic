package enadev.spring.sfgpetclinic.repositories;

import enadev.spring.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
