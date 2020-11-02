package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.UserRepository;
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
    private UserRepository patientRepository ;
    private EntityManager em;

    @Override
    protected void doInit() {
        try {
            em = JpaUtil.getEntityManager();
            patientRepository = new UserRepository(em);
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
    public List<PatientRepresentation> getPatients(){
        ResourceUtils.checkRole(this, CustomRole.ROLE_DOCTOR.getRoleName());
        List<ApplicationUser> users= patientRepository.findAll();
        List<PatientRepresentation> patientRepresentationList = new ArrayList<>();
        users.forEach(user -> patientRepresentationList.add(PatientRepresentation.getPatientRepresentation((Patient) user)));

        return patientRepresentationList;
    }
}