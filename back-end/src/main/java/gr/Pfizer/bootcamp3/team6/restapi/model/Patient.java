package gr.Pfizer.bootcamp3.team6.restapi.model;

import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.time.temporal.ChronoUnit.DAYS;

@Setter
@Getter
@Entity
@DiscriminatorValue("patient")
public class Patient extends ApplicationUser{
    @Transient
    private long nubmerOfDaysIneed;
    private LocalDate lastConsultedOrSignedUp;
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
        setRole(CustomRole.ROLE_PATIENT);
        nubmerOfDaysIneed = 0;
    }

    public boolean checkIfInNeed()
    {
        long daysWithoutConsultation = DAYS.between(lastConsultedOrSignedUp,LocalDate.now(Clock.systemUTC()));
        if(daysWithoutConsultation >= 29)
        {
            if(daysWithoutConsultation != 29)
                nubmerOfDaysIneed = daysWithoutConsultation - 29;

            return true;
        }

        return false;
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

    public List<Carb> getListOfCarbMeasurements() {
        return listOfCarbMeasurements.stream().filter(carb -> carb.checkIfActive()).collect(Collectors.toList());
    }

    public List<Glucose> getListOfGlucoseMeasurements() {
        return listOfGlucoseMeasurements.stream().filter(glucose -> glucose.checkIfActive()).collect(Collectors.toList());
    }
}