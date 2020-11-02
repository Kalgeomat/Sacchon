package gr.Pfizer.bootcamp3.team6.restapi.model;

import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.time.temporal.ChronoUnit.DAYS;

@Setter
@Getter
@Entity
@DiscriminatorValue("patient")
public class Patient extends ApplicationUser{
    public Patient()
    {
        setRole(CustomRole.ROLE_PATIENT);
    }

    private LocalDate lastConsultedOrSignedUp;
    @ManyToOne
    private Doctor doctor;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Consultation> listOfConsultations = new ArrayList<>();

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Carb> listOfCarbMeasurements = new ArrayList<>();

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Glucose> listOfGlucoseMeasurements = new ArrayList<>();

    public boolean checkIfInNeed()
    {
        long daysWithoutConsultation = DAYS.between(lastConsultedOrSignedUp,LocalDate.now(Clock.systemUTC()));
        return daysWithoutConsultation >= 29;
    }
    public boolean checkIfIsNew() {

        if (doctor==null || !doctor.checkIfActive()){
            return checkIfInNeed();
        }else{
            return false;
        }
    }
    public void addConsultation(Consultation consultation)
    {
        listOfConsultations.add(consultation);
        lastConsultedOrSignedUp = LocalDate.now(Clock.systemUTC());
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
}