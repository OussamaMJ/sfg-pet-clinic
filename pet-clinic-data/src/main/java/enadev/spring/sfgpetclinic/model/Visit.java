package enadev.spring.sfgpetclinic.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Visit {

    private LocalDate date;
    private String description;

/*    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;*/
}
