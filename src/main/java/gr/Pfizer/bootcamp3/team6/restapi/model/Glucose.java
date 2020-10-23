package gr.Pfizer.bootcamp3.team6.restapi.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Glucose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date creationDate;
    private Time creationTime;
    private double level;

    @ManyToOne
    private Patient patient;
}
