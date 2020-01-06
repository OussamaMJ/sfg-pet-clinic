package enadev.spring.sfgpetclinic.service;

import enadev.spring.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet pet);
    Set<Vet> findAll();
}