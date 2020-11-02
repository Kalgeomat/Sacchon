package gr.Pfizer.bootcamp3.team6.restapi.representation;

import gr.Pfizer.bootcamp3.team6.restapi.model.Doctor;
import gr.Pfizer.bootcamp3.team6.restapi.model.Gender;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class DoctorRepresentation {
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

    static public Doctor getDoctor(DoctorRepresentation doctorRepresentation){
        Doctor doctor = new Doctor();

        doctor.setUsername(doctorRepresentation.getUsername());
        doctor.setFirstName(doctorRepresentation.getFirstName());
        doctor.setLastName(doctorRepresentation.getLastName());
        doctor.setEmail(doctorRepresentation.getEmail());
        doctor.setPassword(doctorRepresentation.getPassword());
        doctor.setTelephoneNumber(doctorRepresentation.getTelephoneNumber());
        doctor.setAddress(doctorRepresentation.getAddress());
        doctor.setDob(doctorRepresentation.getDob());
        //doctor.setGender(doctorRepresentation.getGender());

        return doctor;
    }
    static public DoctorRepresentation  getDoctorRepresentation (Doctor doctor){
        DoctorRepresentation  doctorRepresentation  = new DoctorRepresentation ();

        doctorRepresentation.setId(doctor.getId());
        doctorRepresentation.setUsername(doctor.getUsername());
        doctorRepresentation.setFirstName(doctor.getFirstName());
        doctorRepresentation.setLastName(doctor.getLastName());
        doctorRepresentation.setEmail(doctor.getEmail());
        doctorRepresentation.setTelephoneNumber(doctor.getTelephoneNumber());
        doctorRepresentation.setAddress(doctor.getAddress());
        doctorRepresentation.setDob(doctor.getDob());
        doctorRepresentation.setGender(doctor.getGender());
        doctorRepresentation.setUri("http://localhost:9000/SacchonApp/doctor/"+doctor.getId());

        return doctorRepresentation;
    }
}