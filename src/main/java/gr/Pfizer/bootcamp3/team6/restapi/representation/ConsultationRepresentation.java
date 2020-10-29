package gr.Pfizer.bootcamp3.team6.restapi.representation;

import gr.Pfizer.bootcamp3.team6.restapi.model.Consultation;
import lombok.Data;

import java.util.Date;

@Data
public class ConsultationRepresentation {
    private long id;
    private String description;
    private Date dateCreated;
    private long doctorId;
    private long patientId;
    private String uri;

    static public Consultation getConsultation(ConsultationRepresentation consultationRepresentation){
        Consultation consultation = new Consultation();

        consultation.setDateCreated(consultationRepresentation.getDateCreated());
        consultation.setDescription(consultationRepresentation.getDescription());

        return consultation;
    }

    static public ConsultationRepresentation  getConsultationRepresentation(Consultation consultation){
        ConsultationRepresentation  consultationRepresentation  = new ConsultationRepresentation();

        consultationRepresentation.setId(consultation.getId());
        consultationRepresentation.setDateCreated(consultation.getDateCreated());
        consultationRepresentation.setDescription(consultation.getDescription());
        consultationRepresentation.setDoctorId(consultation.getPatient().getDoctor().getId());
        consultationRepresentation.setPatientId(consultation.getPatient().getId());
        consultationRepresentation.setUri("http://localhost:9000/SacchonApp/consultations/" + consultation.getId());

        return consultationRepresentation;
    }
}