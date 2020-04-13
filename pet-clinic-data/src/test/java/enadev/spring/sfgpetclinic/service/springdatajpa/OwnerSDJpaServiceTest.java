package enadev.spring.sfgpetclinic.service.springdatajpa;

import enadev.spring.sfgpetclinic.model.Owner;
import enadev.spring.sfgpetclinic.repositories.OwnerRepository;
import enadev.spring.sfgpetclinic.repositories.PetRepository;
import enadev.spring.sfgpetclinic.repositories.PetTypeRepository;
import enadev.spring.sfgpetclinic.service.springdatamongo.OwnerSDMService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    private static final String LAST_NAME = "Oussama";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDMService ownerSDMService;

    Owner returnOwner;
    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id("1").lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id("1").lastName(LAST_NAME).build();
        when(ownerSDMService.findByLastName(any())).thenReturn(returnOwner);
        Owner owner = ownerSDMService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownersList = new HashSet<>();
        ownersList.add(Owner.builder().id("1").build());
        ownersList.add(Owner.builder().id("2").build());

        when(ownerRepository.findAll()).thenReturn(ownersList);

        Set<Owner> owners = ownerSDMService.findAll();
        assertNotNull(owners);
        assertEquals(2,owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyString())).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerSDMService.findById("1");
        assertEquals("1",owner.getId());
        assertNotNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id("1").build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerSDMService.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDMService.delete(returnOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDMService.deleteById("1");
        verify(ownerRepository).deleteById(anyString());
    }
}