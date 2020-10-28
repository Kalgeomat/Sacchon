package gr.Pfizer.bootcamp3.team6.restapi.representation;

import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.model.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class PatientRepresentation {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private long telephoneNumber;
    private String address;
    private Date dob;
    private Gender gender;

    private String uri;

    static public Patient getPatient(PatientRepresentation patientRepresentation){
        Patient patient = new Patient();

        patient.setFirstName(patientRepresentation.getFirstName());
        patient.setLastName(patientRepresentation.getLastName());
        patient.setEmail(patientRepresentation.getEmail());
        patient.setPassword(patientRepresentation.getPassword());
        patient.setTelephoneNumber(patientRepresentation.getTelephoneNumber());
        patient.setAddress(patientRepresentation.getAddress());
        patient.setDob(patientRepresentation.getDob());
        patient.setGender(patientRepresentation.getGender());

        return patient;
    }
    static public PatientRepresentation  getPatientRepresentation(Patient patient){
        PatientRepresentation  patientRepresentation  = new PatientRepresentation();

        patientRepresentation.setId(patient.getId());
        patientRepresentation.setFirstName(patient.getFirstName());
        patientRepresentation.setLastName(patient.getLastName());
        patientRepresentation.setEmail(patient.getEmail());
        patientRepresentation.setPassword(patient.getPassword());
        patientRepresentation.setTelephoneNumber(patient.getTelephoneNumber());
        patientRepresentation.setAddress(patient.getAddress());
        patientRepresentation.setDob(patient.getDob());
        patientRepresentation.setGender(patient.getGender());
        patientRepresentation.setUri("http://localhost:9000/SacchonApp/patient/"+patient.getId());

        return patientRepresentation;
    }
}