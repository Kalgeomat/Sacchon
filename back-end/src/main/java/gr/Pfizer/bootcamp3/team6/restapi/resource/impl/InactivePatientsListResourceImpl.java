package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.model.util.Reporter;
import gr.Pfizer.bootcamp3.team6.restapi.repository.UserRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.InactivePatientsListResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class InactivePatientsListResourceImpl extends ServerResource implements InactivePatientsListResource {
    private UserRepository userRepository;
    private EntityManager em;
    private Date startDate;
    private Date endDate;

    @Override
    protected void doInit() throws ResourceException {
        try {
            em = JpaUtil.getEntityManager();
            userRepository = new UserRepository(em);
            long start = Long.parseLong(getAttribute("startDate")); // takes the "startDate" from the path and transforms it to long
            long end = Long.parseLong(getAttribute("endDate")); // takes the "endDate" from the path and transforms it to long
            startDate = new Date(start);
            endDate = new Date(end);
        } catch (Exception ex) {
            throw new ResourceException(ex);
        }
    }

    @Override
    protected void doRelease() throws ResourceException {
        em.close();
    }

    @Override
    public List<PatientRepresentation> getInactivePatients() throws NotFoundException {
        ResourceUtils.checkRole(this, CustomRole.ROLE_CHIEF_DOCTOR.getRoleName());

        List<ApplicationUser> users= userRepository.findAll();
        // retrieve only the ones that are patients
        List<ApplicationUser> patients = users.stream().filter(user -> user instanceof Patient).collect(Collectors.toList());
        patients = Reporter.getInactivePatients(patients,startDate,endDate);

        List<PatientRepresentation> patientRepresentationList = new ArrayList<>();
        patients.forEach(user -> patientRepresentationList.add(PatientRepresentation.getPatientRepresentation((Patient) user)));

        return patientRepresentationList;
    }
}

