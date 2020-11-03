package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.model.util.Reporter;
import gr.Pfizer.bootcamp3.team6.restapi.repository.UserRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientActivityRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.PatientActivityResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;
import java.util.Date;
import java.util.Optional;

public class PatientActivityResourceImpl extends ServerResource implements PatientActivityResource {
    private UserRepository userRepository;
    private EntityManager em;
    private long patientId;
    private Date startDate;
    private Date endDate;

    @Override
    protected void doInit() throws ResourceException {
        try {
            em = JpaUtil.getEntityManager();
            userRepository = new UserRepository(em);
            patientId = Long.parseLong(getAttribute("id")); // takes the "id" from the path and transforms it to long
            long start = Long.parseLong(getAttribute("startDate")); // takes the "startDate" from the path and transforms it to long
            long end = Long.parseLong(getAttribute("endDate")); // takes the "endDate" from the path and transforms it to long
            startDate = new Date(start);
            endDate = new Date(end);
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
    public PatientActivityRepresentation getPatientActivity() throws NotFoundException {
        ResourceUtils.checkRole(this, CustomRole.ROLE_CHIEF_DOCTOR.getRoleName());

        Optional<ApplicationUser> user = userRepository.findById(patientId);
        setExisting(user.isPresent());
        if (!user.isPresent())  throw new NotFoundException("Patient is not found");

        int numberOfmeasurements = Reporter.getActivityForPatient(user.get(),startDate,endDate);
        PatientActivityRepresentation patientActivityRepresentation = new PatientActivityRepresentation();
        patientActivityRepresentation.setNumberOfMeasurements(numberOfmeasurements);
        patientActivityRepresentation.setCurrentDate(new Date());
        patientActivityRepresentation.setPatientId(patientId);

        return patientActivityRepresentation;
    }
}