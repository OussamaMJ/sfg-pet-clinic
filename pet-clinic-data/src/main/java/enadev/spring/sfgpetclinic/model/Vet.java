package enadev.spring.sfgpetclinic.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vet extends Person {
/*    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "spec_id"))*/
    @DBRef
    private Set<Speciality> specialities = new HashSet<>();
}
