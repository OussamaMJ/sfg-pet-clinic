package enadev.spring.sfgpetclinic.model;


import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Pet{

    private String id;
    private String name;
    // @ManyToOne @JoinColumn(name = "type_id")
    // private PetType petType;
    // @ManyToOne @JoinColumn(name = "owner_id")
    // private Owner owner;

    private LocalDate birthDay;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
   // private Set<Visit> visits = new HashSet<>();

    @Builder
    public Pet(String id, String name, PetType petType, Owner owner, LocalDate birthDay, Set<Visit> visits) {
        this.id = id;
        this.name = name;
       // this.petType = petType;
       // this.owner = owner;
        this.birthDay = birthDay;
       // if(visits != null) this.visits = visits;
    }


}
