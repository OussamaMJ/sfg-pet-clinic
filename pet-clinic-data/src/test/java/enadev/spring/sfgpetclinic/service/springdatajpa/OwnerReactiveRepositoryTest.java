package enadev.spring.sfgpetclinic.service.springdatajpa;

import enadev.spring.sfgpetclinic.model.Owner;
import enadev.spring.sfgpetclinic.repositories.reactive.OwnerReactiveRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
//@SpringBootTest
@DataMongoTest
public class OwnerReactiveRepositoryTest {
    @Autowired
    OwnerReactiveRepository ownerReactiveRepository;

    @BeforeEach
    public void setUp(){
        ownerReactiveRepository.deleteAll().block();
    }

    @Test
    public void testOwnerSave() throws Exception{
        Owner owner = Owner.builder().firstName("Reactive Owner").build();
        ownerReactiveRepository.save(owner).block();
        Long count = ownerReactiveRepository.count().block();
        Assertions.assertEquals(Long.valueOf(1L),count);
    }

    @Test
    public void findOwnersByLastName() throws Exception{
        Owner owner = Owner.builder().lastName("Reactive").build();
        ownerReactiveRepository.save(owner).block();
        Owner owners = ownerReactiveRepository.findAllByLastName("Reactive").blockFirst();
        Assertions.assertEquals("Reactive",owners.getLastName());
    }


}
