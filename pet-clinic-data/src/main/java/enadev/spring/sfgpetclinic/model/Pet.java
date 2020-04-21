package enadev.spring.sfgpetclinic.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

public class Pet{
    @Id
    private String id;
    private String name;
    @DBRef
    private PetType petType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    @DBRef
    private Set<Visit> visits = new HashSet<>();

    private boolean new_;

    @Builder
    public Pet(String id, String name, PetType petType, Owner owner, LocalDate birthDay, Set<Visit> visits) {
        this.id = id;
        this.name = name;
        this.petType = petType;
        this.birthDay = birthDay;
        if(visits != null) this.visits = visits;
    }

    public boolean isNew_() {
        if(this.getId() == null || this.getId().equals("")) return true;
        else return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
