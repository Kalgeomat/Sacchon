package gr.Pfizer.bootcamp3.team6.restapi.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateCreated;
    private String description;
    private boolean isActive;

    @ManyToOne
    private Patient patient;

    public Consultation()
    {
        setActive(true);
    }

    public boolean checkIfActive()
    {
        return isActive;
    }
}