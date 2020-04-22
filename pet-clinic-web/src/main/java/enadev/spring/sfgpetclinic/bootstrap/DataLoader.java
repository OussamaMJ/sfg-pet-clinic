package enadev.spring.sfgpetclinic.bootstrap;

import enadev.spring.sfgpetclinic.model.*;
import enadev.spring.sfgpetclinic.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Slf4j
@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;
    private final PetService petService;

/*
    @Autowired OwnerReactiveRepository ownerReactiveRepository;
    @Autowired PetReactiveRepository petReactiveRepository;
    @Autowired PetTypeReactiveRepository petTypeReactiveRepository;
    @Autowired VisitReactiveRepository visitReactiveRepository;
    @Autowired VetReactiveRepository vetReactiveRepository;
    @Autowired SpecialityReactiveRepository specialityReactiveRepository;
*/


    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) loadData();

/*        log.error("Start Reactive ------------");
        log.error(" Number of owners "+ownerReactiveRepository.count().block().toString());
        log.error(" Number of pets "+petReactiveRepository.count().block().toString());
        log.error(" Number of pet types "+petTypeReactiveRepository.count().block().toString());
        log.error(" Number of visits "+visitReactiveRepository.count().block().toString());
        log.error(" Number of vets "+vetReactiveRepository.count().block().toString());
        log.error(" Number of specialities "+specialityReactiveRepository.count().block().toString());
        log.error("End Reactive --------------");*/
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setPetName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setPetName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Oussama");
        owner1.setLastName("MJIHIL");
        owner1.setAddress("10 Rue Drissa");
        owner1.setCity("Settat");
        owner1.setTelephone("0614483486");

        Pet ousPet = new Pet();
        ousPet.setPetType(savedDogPetType);
        ousPet.setBirthDay(LocalDate.now());
        ousPet.setName("Putchi");

        Visit visit1 = new Visit();
        visit1.setDate(LocalDate.now());
        visit1.setDescription("sneeezy kitty");

        Visit savedVisit = visitService.save(visit1);
        ousPet.getVisits().add(savedVisit);
        Pet savedPet = petService.save(ousPet);
        owner1.getPets().add(savedPet);
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
        vet1.getSpecialities().add(savedDentistry);
        vetService.save(vet1);

        System.out.println("Loaded Vets");
    }
}
