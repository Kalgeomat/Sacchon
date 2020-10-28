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
import java.util.List;
import java.util.Optional;

public class ConsultationListResourceImpl extends ServerResource implements ConsultationListResource {
    private ConsultationRepository consultationRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;
    private EntityManager em;

    @Override
    protected void doInit() throws ResourceException {
        try {
            em = JpaUtil.getEntityManager();
            consultationRepository = new ConsultationRepository(em);
            doctorRepository = new DoctorRepository(em);
            patientRepository = new PatientRepository(em);
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
        consultationRepository.save(consultation);

        // this is where the mapping or relationship is done
        System.out.println("The doctor id of the consultation: " + consultationRepresentation.getDoctorId());
        Doctor doctorConsulting = doctorRepository.findById(consultationRepresentation.getDoctorId()).get();
        Patient patientConsulted = patientRepository.findById(consultationRepresentation.getPatientId()).get();
        doctorConsulting.consultPatient(patientConsulted,consultation);

        return ConsultationRepresentation.getConsultationRepresentation(consultation);
    }

    @Override
    public List<ConsultationRepresentation> getConsultations() throws NotFoundException {
        return null;
    }
}