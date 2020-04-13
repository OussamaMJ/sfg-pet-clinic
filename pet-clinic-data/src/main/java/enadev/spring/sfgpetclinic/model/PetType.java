package enadev.spring.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor

public class PetType{
    @Id
    private String id;
    private String petName;

    @Builder
    public PetType(String id, String petName) {
        this.id = id;
        this.petName = petName;
    }

    @Override
    public String toString() {
        return petName;
    }
}
