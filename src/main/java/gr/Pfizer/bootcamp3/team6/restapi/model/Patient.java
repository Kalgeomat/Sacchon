package gr.Pfizer.bootcamp3.team6.restapi.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private long telephoneNumber;
    private String address;
    private Date dob;
    private Gender gender;
    private Date lastConsultedOrSignedUp;
    private boolean isActive;
    @ManyToOne
    private Doctor doctor;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Consultation> listOfConsultations = new ArrayList<>();

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Carb> listOfCarbMeasurements = new ArrayList<>();

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Glucose> listOfGlucoseMeasurements = new ArrayList<>();

    public Patient()
    {
        setActive(true);
    }

    public boolean checkIfInNeed()
    {
        return false;
    }

    public void addConsultation(Consultation consultation)
    {
        listOfConsultations.add(consultation);
    }

    public void addCarbMeasurement(Carb carbMeasurement)
    {
        carbMeasurement.setPatient(this);
        listOfCarbMeasurements.add(carbMeasurement);
    }

    public void addGlucoseMeasurement(Glucose glucoseMeasurement)
    {
        glucoseMeasurement.setPatient(this);
        listOfGlucoseMeasurements.add(glucoseMeasurement);
    }

    public boolean checkIfActive()
    {
        return isActive;
    }
}