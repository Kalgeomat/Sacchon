package gr.Pfizer.bootcamp3.team6.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@Entity
public class Carb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double carbInTake;
    private Date dateMeasured;
    private boolean isActive;

    @ManyToOne
    private Patient patient;

    public Carb()
    {
        setActive(true);
    }

    public boolean checkIfActive()
    {
        return isActive;
    }
}
