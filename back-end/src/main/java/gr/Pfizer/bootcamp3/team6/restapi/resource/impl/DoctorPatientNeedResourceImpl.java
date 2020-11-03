package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.UserRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientIneedRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.DoctorPatientNeedResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorPatientNeedResourceImpl extends ServerResource implements DoctorPatientNeedResource {
    private UserRepository userRepository;
    private EntityManager em;
    private long doctorId;

    @Override
    protected void doInit() throws ResourceException {
        try {
            em = JpaUtil.getEntityManager();
            userRepository = new UserRepository(em);
            doctorId = Long.parseLong(getAttribute("id")); // takes the "id" from the path and transforms it to long
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
    public List<PatientIneedRepresentation> getDoctorPatientsNeed() {
        ResourceUtils.checkRole(this, CustomRole.ROLE_DOCTOR.getRoleName());

        List<ApplicationUser> users= userRepository.findAll();
        // retrieve only the ones that are patients
        List<ApplicationUser> patients = users.stream().filter(user -> user instanceof Patient).collect(Collectors.toList());

        List<Patient> patientsIneed = getPatientNeedForDoctor(patients);
        List<PatientIneedRepresentation> patientIneedRepresentationList = new ArrayList<>();
        patientsIneed.forEach(patient ->patientIneedRepresentationList.add(PatientIneedRepresentation.getPatientIneedRepresentation(patient)));

        return patientIneedRepresentationList;
    }

    private List<Patient> getPatientNeedForDoctor(List<ApplicationUser> allPatients) {
        List<Patient> doctorPatientsIneed = new ArrayList<>();

        allPatients.forEach(user -> {
            Patient patient = (Patient) user;
            if (patient.checkIfInNeed() && patient.getDoctor().getId() == doctorId)
                doctorPatientsIneed.add(patient);
        });

        return doctorPatientsIneed;
    }
}