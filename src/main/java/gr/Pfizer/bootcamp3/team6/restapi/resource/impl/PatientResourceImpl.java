package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Doctor;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.PatientRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.DoctorRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.PatientResource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import java.util.Optional;

public class PatientResourceImpl extends ServerResource implements PatientResource {

    private PatientRepository patientRepository ;
    private EntityManager em;
    private long id;



    @Override
    protected void doInit() {
        try {
            em = JpaUtil.getEntityManager();
            patientRepository = new PatientRepository(em); //parametro pou pairnoun ta repository
            id = Long.parseLong(getAttribute("id")); //to diavazei apo to path kai to metatrepei
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
    public PatientRepresentation getPatient() throws NotFoundException, ResourceException {


        //ResourceUtils.checkRole(this, CustomRole.ROLE_USER.getRoleName());
        Optional<Patient> patient = patientRepository.findById(id);
        setExisting(patient.isPresent());
        if (!patient.isPresent())  throw new NotFoundException("Doctor is not found");
        PatientRepresentation patientRepresentation = PatientRepresentation.getPatientRepresentation(patient.get());
        return patientRepresentation;
    }


    @Override
    public void remove() throws NotFoundException {

    }

    @Override
    public PatientRepresentation update(PatientRepresentation patientReprIn) throws NotFoundException, BadEntityException {
        return null;
    }
}
