package gr.Pfizer.bootcamp3.team6.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private LocalDate creationDate;

    @ManyToOne
    private Patient patient;
}
