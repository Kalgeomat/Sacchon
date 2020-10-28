package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Consultation;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.ConsultationRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.PatientRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.ConsultationRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.ConsultationResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.PatientResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import java.util.Optional;

public class ConsultationResourceImpl extends ServerResource implements ConsultationResource {
    private ConsultationRepository consultationRepository ;
    private EntityManager em;
    private long id;

    @Override
    protected void doInit() {
        try {
            em = JpaUtil.getEntityManager();
            consultationRepository = new ConsultationRepository(em);
            id = Long.parseLong(getAttribute("id")); // takes the "id" from the path and transforms it to long
        }
        catch(Exception ex){
            throw new ResourceException(ex);
        }
    }

    @Override
    protected void doRelease() {
        em.close();
    }

    @Override
    public ConsultationRepresentation getConsultation() throws NotFoundException, ResourceException {
        ResourceUtils.checkRole(this, CustomRole.ROLE_PATIENT.getRoleName());
        Optional<Consultation> consultation = consultationRepository.findById(id);
        setExisting(consultation.isPresent());
        if (!consultation.isPresent())  throw new NotFoundException("Consultation is not found");
        ConsultationRepresentation consultationRepresentation = ConsultationRepresentation.getConsultationRepresentation(consultation.get());
        return consultationRepresentation;
    }

    @Override
    public ConsultationRepresentation update(ConsultationRepresentation consultationRepresentation) throws NotFoundException, BadEntityException {
        return null;
    }

    @Override
    public void remove() throws NotFoundException {

    }


}