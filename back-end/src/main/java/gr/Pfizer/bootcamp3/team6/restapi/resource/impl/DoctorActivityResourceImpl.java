package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.model.util.Reporter;
import gr.Pfizer.bootcamp3.team6.restapi.repository.UserRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.DoctorActivityRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.DoctorActivityResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;
import java.util.Date;
import java.util.Optional;

public class DoctorActivityResourceImpl extends ServerResource implements DoctorActivityResource {
    private UserRepository userRepository;
    private EntityManager em;
    private long doctorId;
    private Date startDate;
    private Date endDate;

    @Override
    protected void doInit() throws ResourceException {
        try {
            em = JpaUtil.getEntityManager();
            userRepository = new UserRepository(em);
            doctorId = Long.parseLong(getAttribute("id")); // takes the "id" from the path and transforms it to long
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
    public DoctorActivityRepresentation getDoctorActivity() throws NotFoundException {
        ResourceUtils.checkRole(this, CustomRole.ROLE_CHIEF_DOCTOR.getRoleName());

        Optional<ApplicationUser> user = userRepository.findById(doctorId);
        setExisting(user.isPresent());
        if (!user.isPresent())  throw new NotFoundException("Patient is not found");

        int numberOfConsultations = Reporter.getActivityForDoctor(user.get(),startDate,endDate);
        DoctorActivityRepresentation doctorActivityRepresentation = new DoctorActivityRepresentation();
        doctorActivityRepresentation.setNumberOfConsultations(numberOfConsultations);
        doctorActivityRepresentation.setCurrentDate(new Date());
        doctorActivityRepresentation.setDoctorId(doctorId);

        return doctorActivityRepresentation;
    }
}
