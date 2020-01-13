package enadev.spring.sfgpetclinic.service;

import enadev.spring.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudInterface<Owner,Long>{
    Owner findByLastName(String lastName);
}
