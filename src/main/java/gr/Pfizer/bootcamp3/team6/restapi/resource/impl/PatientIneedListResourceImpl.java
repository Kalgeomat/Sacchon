package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.UserRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientIneedRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.PatientIneedListResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientIneedListResourceImpl extends ServerResource implements PatientIneedListResource {
    private UserRepository userRepository;
    private EntityManager em;

    @Override
    protected void doInit() throws ResourceException {
        try {
            em = JpaUtil.getEntityManager();
            userRepository = new UserRepository(em);
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
    public List<PatientIneedRepresentation> getPatients() throws ResourceException {
        ResourceUtils.checkRole(this, CustomRole.ROLE_CHIEF_DOCTOR.getRoleName());

        List<ApplicationUser> users= userRepository.findAll();
        // retrieve only the ones that are patients
        List<ApplicationUser> patients = users.stream().filter(user -> user instanceof Patient).collect(Collectors.toList());

        List<Patient> patientIneed = getPatientIneed(patients);
        List<PatientIneedRepresentation> patientIneedRepresentationList = new ArrayList<>();
        patientIneed.forEach(patient ->patientIneedRepresentationList.add(PatientIneedRepresentation.getPatientIneedRepresentation(patient)));

        return patientIneedRepresentationList;
    }

    // utility method
    private List<Patient> getPatientIneed(List<ApplicationUser> allUsers)
    {
        List<ApplicationUser> allPatients = allUsers.stream().filter(user -> user instanceof Patient).collect(Collectors.toList());
        List<Patient> patientsIneed = new ArrayList<>();

        allPatients.forEach(user -> {
            Patient patient = (Patient) user;
            if(patient.checkIfInNeed())
                patientsIneed.add(patient);
        });

        return  patientsIneed;
    }
}
