package enadev.spring.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.HashSet;
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

    private boolean new_;

    @DBRef
    private Set<Pet> pets = new HashSet<>();

    public Pet getPet(String petName){
        return getPet(petName,false);
    }
    public Pet getPet(String name, boolean b) {
        name = name.toLowerCase();
        for(Pet pet: pets){
            if(!b || !pet.isNew_()){
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if(compName.equals(name)) return pet;
            }
        }
        return null;
    }

    public boolean isNew_() {
        if(this.getId() != null) return false;
        else return true;
    }
}
