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
@NoArgsConstructor
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int telephoneNumber;
    private String address;
    private Date dob;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Patient> listOfPatients = new ArrayList<>();

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Consultation> listOfConsultations = new ArrayList<>();
}
