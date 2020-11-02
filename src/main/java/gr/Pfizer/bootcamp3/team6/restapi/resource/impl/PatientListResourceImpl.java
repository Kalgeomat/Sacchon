package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.model.Doctor;
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
import java.util.stream.Collectors;

public class PatientListResourceImpl extends ServerResource implements PatientListResource {
    private UserRepository userRepository;
    private EntityManager em;

    @Override
    protected void doInit() {
        try {
            em = JpaUtil.getEntityManager();
            userRepository = new UserRepository(em);
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
        List<String> roles = new ArrayList<>();
        roles.add(CustomRole.ROLE_CHIEF_DOCTOR.getRoleName());
        roles.add(CustomRole.ROLE_DOCTOR.getRoleName());
        ResourceUtils.checkRoles(this, roles);

        List<ApplicationUser> users= userRepository.findAll();
        // retrieve only the ones that are patients
        List<ApplicationUser> patients = users.stream().filter(user -> user instanceof Patient).collect(Collectors.toList());

        List<PatientRepresentation> patientRepresentationList = new ArrayList<>();
        patients.forEach(user -> patientRepresentationList.add(PatientRepresentation.getPatientRepresentation((Patient) user)));

        return patientRepresentationList;
    }
}