package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.PatientRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.PatientListResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class PatientListResourceImpl extends ServerResource implements PatientListResource {
    private PatientRepository patientRepository ;
    private EntityManager em;

    @Override
    protected void doInit() {
        try {
            em = JpaUtil.getEntityManager();
            patientRepository = new PatientRepository(em);

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
    public PatientRepresentation add(PatientRepresentation patientIn) throws BadEntityException {

        ResourceUtils.checkRole(this, CustomRole.ROLE_CHIEF_DOCTOR.getRoleName());
        if (patientIn==null) throw new  BadEntityException("Null patient representation error");
        if (patientIn.getLastName().equals("admin")) throw new  BadEntityException("Invalid patient name error");

        Patient patient = PatientRepresentation.getPatient(patientIn);


        patientRepository.save(patient);


        return PatientRepresentation.getPatientRepresentation(patient);
    }

    @Override
    public List<PatientRepresentation> getPatients() throws NotFoundException {
        ResourceUtils.checkRole(this, CustomRole.ROLE_CHIEF_DOCTOR.getRoleName());
        List<Patient> patients= patientRepository.findAll();

        List<PatientRepresentation> patientRepresentationList = new ArrayList<>();

        patients.forEach(patient -> patientRepresentationList.add(PatientRepresentation.getPatientRepresentation(patient)));

        return patientRepresentationList;

    }



}

