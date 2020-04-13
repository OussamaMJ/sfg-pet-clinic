package enadev.spring.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Owner extends Person {
    @Builder
    public Owner(String  id, String firstName, String lastName, String address, String city,
                 String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        //if(pets != null) {this.pets = pets;}
    }
    private String address;
    private String city;
    private String telephone;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    //private Set<Pet> pets = new HashSet<>();

/*    public Pet getPet(String petName){
        return getPet(petName,false);
    }*/
/*    public Pet getPet(String name, boolean b) {
        name = name.toLowerCase();
        for(Pet pet: pets){
            if(!b || !pet.isNew()){
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if(compName.equals(name)) return pet;
            }
        }
        return null;
    }*/
}
