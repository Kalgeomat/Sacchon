package gr.Pfizer.bootcamp3.team6.restapi.model;

import gr.Pfizer.bootcamp3.team6.restapi.model.interfaces.Measurement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@Entity
public class Carb implements Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "carbInTake")
    private double measurementData;
    private Date dateMeasured;
    private boolean isActive;

    @ManyToOne
    private Patient patient;

    public Carb(){
        setActive(true);
    }

    public boolean checkIfActive(){
        return isActive;
    }
}
