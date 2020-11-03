package gr.Pfizer.bootcamp3.team6.restapi.representation;

import gr.Pfizer.bootcamp3.team6.restapi.model.Gender;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import lombok.Data;
import java.util.Date;

@Data
public class PatientIneedRepresentation {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private long telephoneNumber;
    private String address;
    private Date dob;
    private Gender gender;
    private String uri;
    private long nubmerOfDaysIneed;

    static public PatientIneedRepresentation  getPatientIneedRepresentation(Patient patient){
        PatientIneedRepresentation  patientIneedRepresentation  = new PatientIneedRepresentation();

        patientIneedRepresentation.setId(patient.getId());
        patientIneedRepresentation.setUsername(patient.getUsername());
        patientIneedRepresentation.setFirstName(patient.getFirstName());
        patientIneedRepresentation.setLastName(patient.getLastName());
        patientIneedRepresentation.setEmail(patient.getEmail());
        patientIneedRepresentation.setTelephoneNumber(patient.getTelephoneNumber());
        patientIneedRepresentation.setAddress(patient.getAddress());
        patientIneedRepresentation.setDob(patient.getDob());
        patientIneedRepresentation.setGender(patient.getGender());
        patientIneedRepresentation.setUri("http://localhost:9000/SacchonApp/patient/"+patient.getId());
        patientIneedRepresentation.setNubmerOfDaysIneed(patient.getNubmerOfDaysIneed());

        return patientIneedRepresentation;
    }
}