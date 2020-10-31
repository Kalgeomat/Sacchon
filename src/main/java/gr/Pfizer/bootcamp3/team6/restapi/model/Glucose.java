package gr.Pfizer.bootcamp3.team6.restapi.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Setter
@Getter
@Entity
public class Glucose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateMeasured;
    private double bloodGlucoseLevel;
    private boolean isActive;

    @ManyToOne
    private Patient patient;

    public Glucose()
    {
        setActive(true);
    }

    public boolean checkIfActive()
    {
        return isActive;
    }
}