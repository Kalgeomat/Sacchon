package gr.Pfizer.bootcamp3.team6.restapi.representation;

import gr.Pfizer.bootcamp3.team6.restapi.model.Doctor;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import lombok.Data;

import java.util.Date;

@Data
public class DoctorRepresentation {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int telephoneNumber;
    private String address;
    private Date dob;

    private String uri;

    static public Doctor getDoctor(DoctorRepresentation doctorRepresentation){
        Doctor doctor = new Doctor();

        doctor.setFirstName(doctorRepresentation.getFirstName());
        doctor.setLastName(doctorRepresentation.getLastName());
        doctor.setEmail(doctorRepresentation.getEmail());
        doctor.setPassword(doctorRepresentation.getPassword());
        doctor.setTelephoneNumber(doctorRepresentation.getTelephoneNumber());
        doctor.setAddress(doctorRepresentation.getAddress());
        doctor.setDob(doctorRepresentation.getDob());


        return doctor;
    }
    static public DoctorRepresentation  getDoctorRepresentation (Doctor doctor){
        DoctorRepresentation  doctorRepresentation  = new DoctorRepresentation ();

        doctorRepresentation.setFirstName(doctor.getFirstName());
        doctorRepresentation.setLastName(doctor.getLastName());
        doctorRepresentation.setEmail(doctor.getEmail());
        doctorRepresentation.setPassword(doctor.getPassword());
        doctorRepresentation.setTelephoneNumber(doctor.getTelephoneNumber());
        doctorRepresentation.setAddress(doctor.getAddress());
        doctorRepresentation.setDob(doctor.getDob());

        //patientRepresentation.setUri("http://localhost:9000/app/patient/"+patient.getId());
        return doctorRepresentation;


    }
}
