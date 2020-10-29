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
public class Doctor {
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
    private boolean isActive;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Patient> listOfPatients = new ArrayList<>();

    public Doctor()
    {
        setActive(true);
    }

    public void consultPatient(Patient patient, Consultation consultation)
    {
        patient.addConsultation(consultation);
        patient.setDoctor(this);
        listOfPatients.add(patient);
    }

    public boolean checkIfActive()
    {
        return isActive;
    }
}