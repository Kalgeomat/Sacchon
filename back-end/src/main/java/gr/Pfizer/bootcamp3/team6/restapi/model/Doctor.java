package gr.Pfizer.bootcamp3.team6.restapi.model;

import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@DiscriminatorValue("doctor")
public class Doctor extends ApplicationUser{
    public Doctor()
    {
        setRole(CustomRole.ROLE_DOCTOR);
    }

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Patient> listOfPatients = new ArrayList<>();

    public void consultPatient(Patient patient, Consultation consultation)
    {
        consultation.setDateCreated(new Date());
        consultation.setDoctorName(firstName + " " + lastName);
        patient.addConsultation(consultation);
        patient.setDoctor(this);
        listOfPatients.add(patient);
    }
}