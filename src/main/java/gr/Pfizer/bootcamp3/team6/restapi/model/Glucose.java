package gr.Pfizer.bootcamp3.team6.restapi.model;

import gr.Pfizer.bootcamp3.team6.restapi.model.interfaces.Measurement;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
public class Glucose implements Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateMeasured;
    @Column(name = "BloodGlucoseLevel")
    private double measurementData;
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