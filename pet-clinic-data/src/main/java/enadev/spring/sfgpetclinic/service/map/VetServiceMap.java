package enadev.spring.sfgpetclinic.service.map;

import enadev.spring.sfgpetclinic.model.Vet;
import enadev.spring.sfgpetclinic.service.CrudInterface;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudInterface<Vet,Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}