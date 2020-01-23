package enadev.spring.sfgpetclinic.bootstrap;

import enadev.spring.sfgpetclinic.model.Owner;
import enadev.spring.sfgpetclinic.model.Vet;
import enadev.spring.sfgpetclinic.service.OwnerService;
import enadev.spring.sfgpetclinic.service.VetService;
import enadev.spring.sfgpetclinic.service.map.OwnerServiceMap;
import enadev.spring.sfgpetclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Oussama");
        owner1.setLastName("MJIHIL");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Said");
        owner2.setLastName("ZAID");
        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Zakaria");
        vet1.setLastName("Abu");

        vetService.save(vet1);

        System.out.println("Loaded Owners");


    }
}
