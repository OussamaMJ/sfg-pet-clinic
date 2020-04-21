package enadev.spring.sfgpetclinic.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Visit {
    @Id
    private String id;
    private LocalDate date;
    private String description;
}
