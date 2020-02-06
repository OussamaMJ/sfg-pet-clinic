package enadev.spring.sfgpetclinic.bootstrap;

import enadev.spring.sfgpetclinic.model.Owner;
import enadev.spring.sfgpetclinic.model.Pet;
import enadev.spring.sfgpetclinic.model.PetType;
import enadev.spring.sfgpetclinic.model.Vet;
import enadev.spring.sfgpetclinic.service.OwnerService;
import enadev.spring.sfgpetclinic.service.PetTypeService;
import enadev.spring.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setPetName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setPetName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Oussama");
        owner1.setLastName("MJIHIL");
        owner1.setAddress("10 Rue Drissa");
        owner1.setCity("Settat");
        owner1.setTelephone("0614483486");

        Pet ousPet = new Pet();
        ousPet.setPetType(savedDogPetType);
        ousPet.setOwner(owner1);
        ousPet.setBirthDay(LocalDate.now());
        ousPet.setName("Putchi");
        owner1.getPets().add(ousPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Said");
        owner2.setLastName("ZAID");
        owner2.setAddress("10 Rue Drissa");
        owner2.setCity("Settat");
        owner2.setTelephone("0614483486");
        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Zakaria");
        vet1.setLastName("Abu");

        vetService.save(vet1);

        System.out.println("Loaded Owners");


    }
}
