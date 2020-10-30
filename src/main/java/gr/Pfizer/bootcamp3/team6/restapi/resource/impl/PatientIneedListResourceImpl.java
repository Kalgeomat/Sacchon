package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.PatientRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.PatientIneedListResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class PatientIneedListResourceImpl extends ServerResource implements PatientIneedListResource {
    private PatientRepository patientRepository ;
    private EntityManager em;

    @Override
    protected void doInit() throws ResourceException {
        try {
            em = JpaUtil.getEntityManager();
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
    public List<PatientRepresentation> getPatients(){
        ResourceUtils.checkRole(this, CustomRole.ROLE_CHIEF_DOCTOR.getRoleName());

        List<Patient> patients= patientRepository.findAll();
        patients = getPatientIneed(patients);
        List<PatientRepresentation> patientRepresentationList = new ArrayList<>();
        patients.forEach(patient ->patientRepresentationList.add(PatientRepresentation.getPatientRepresentation(patient)));

        return patientRepresentationList;
    }

    // utility method
    private List<Patient> getPatientIneed(List<Patient> allPatients)
    {
        List<Patient> patientsIneed = new ArrayList<>();

        allPatients.forEach(patient -> {
            if(patient.checkIfInNeed())
                patientsIneed.add(patient);
        });

        return  patientsIneed;
    }
}
