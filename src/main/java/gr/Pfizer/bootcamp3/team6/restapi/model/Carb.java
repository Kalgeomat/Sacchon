package gr.Pfizer.bootcamp3.team6.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class Carb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double carbInTake;
    private Date dateMeasured;

    @ManyToOne
    private Patient patient;
}
