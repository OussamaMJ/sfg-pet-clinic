package enadev.spring.sfgpetclinic.model;

import lombok.*;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Speciality{
    @Id
    private  String id;
    private String description;
}
