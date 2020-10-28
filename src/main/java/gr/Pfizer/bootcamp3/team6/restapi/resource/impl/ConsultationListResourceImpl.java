package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Consultation;
import gr.Pfizer.bootcamp3.team6.restapi.model.Doctor;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.ConsultationRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.DoctorRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.PatientRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.ConsultationRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.ConsultationListResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


public class ConsultationListResourceImpl extends ServerResource implements ConsultationListResource {
    private ConsultationRepository consultationRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;
    private EntityManager em;
    private long patientId;

    @Override
    protected void doInit() throws ResourceException {
        try {
            em = JpaUtil.getEntityManager();
            consultationRepository = new ConsultationRepository(em);
            doctorRepository = new DoctorRepository(em);
            patientRepository = new PatientRepository(em);
            patientId = Long.parseLong(getAttribute("id")); // takes the "id" from the path and transforms it to long
        }
        catch(Exception ex){
            throw new ResourceException(ex);
        }
    }

    @Override
    protected void doRelease() throws ResourceException {
        em.close();
    }

    @Override
    public ConsultationRepresentation add(ConsultationRepresentation consultationRepresentation) throws BadEntityException {
        ResourceUtils.checkRole(this, CustomRole.ROLE_DOCTOR.getRoleName());
        if (consultationRepresentation == null) throw new  BadEntityException("Null consultation representation error");

        Consultation consultation = ConsultationRepresentation.getConsultation(consultationRepresentation);

        // this is where the mapping or relationship is done
        System.out.println("The doctor id of the consultation: " + consultationRepresentation.getDoctorId());
        Doctor doctorConsulting = doctorRepository.findById(consultationRepresentation.getDoctorId()).get();
        Patient patientConsulted = patientRepository.findById(patientId).get();
        consultation.setPatient(patientConsulted);
        doctorConsulting.consultPatient(patientConsulted,consultation);
        // this where the consultation is persisted
        consultationRepository.save(consultation);

        return ConsultationRepresentation.getConsultationRepresentation(consultation);
    }

    @Override
    public List<ConsultationRepresentation> getConsultations(){
        List<String> roles = new ArrayList<>();
        roles.add(CustomRole.ROLE_PATIENT.getRoleName());
        //roles.add(CustomRole.ROLE_DOCTOR.getRoleName());

        // ResourceUtils.checkRoles(this, roles);
        List<Consultation> consultations= consultationRepository.findAll();
        consultations = getConsultationsForPatient(consultations);
        List<ConsultationRepresentation> consultationRepresentationList = new ArrayList<>();
        consultations.forEach(consultation -> consultationRepresentationList.add(ConsultationRepresentation.getConsultationRepresentation(consultation)));

        return consultationRepresentationList;
    }

    // utility method
    private List<Consultation> getConsultationsForPatient(List<Consultation> allConsultations)
    {
        List<Consultation> patientConsultations = new ArrayList<>();

        allConsultations.forEach(consultation -> {
            if(consultation.getPatient().getId() == patientId)
                patientConsultations.add(consultation);
        });

        return patientConsultations;
    }
}