package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.UserRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.PatientNewListResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientNewListResourceImpl extends ServerResource implements PatientNewListResource {
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
    public List<PatientRepresentation> getPatients() throws NotFoundException, ResourceException {
        ResourceUtils.checkRole(this, CustomRole.ROLE_DOCTOR.getRoleName());

        List<ApplicationUser> users= userRepository.findAll();
        List<Patient> patients= getPatientNew(users);
        List<PatientRepresentation> patientRepresentationList = new ArrayList<>();
        patients.forEach(patient ->patientRepresentationList.add(PatientRepresentation.getPatientRepresentation(patient)));

        return patientRepresentationList;
    }

    // utility method
    private List<Patient> getPatientNew(List<ApplicationUser> allUsers)
    {
        // retrieve only the ones that are patients
        List<ApplicationUser> allPatients = allUsers.stream().filter(user -> user instanceof Patient).collect(Collectors.toList());
        List<Patient> patientsNew= new ArrayList<>();

        allPatients.forEach(user -> {
            Patient patient =(Patient) user;
            if(patient.checkIfIsNew())
                patientsNew.add(patient);
        });

        return  patientsNew;
    }
}