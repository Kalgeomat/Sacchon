package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.model.Doctor;
import gr.Pfizer.bootcamp3.team6.restapi.repository.UserRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.DoctorRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.DoctorResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;
import java.util.Optional;


public class DoctorResourceImpl extends ServerResource implements DoctorResource {

    private UserRepository userRepository;
    private EntityManager em;
    private long id;

    @Override
    protected void doInit() {
        try {
            em = JpaUtil.getEntityManager();
            userRepository = new UserRepository(em);
            id = Long.parseLong(getAttribute("id"));
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
    public DoctorRepresentation getDoctor() throws NotFoundException, ResourceException, DeletedEntityException {
        ResourceUtils.checkRole(this, CustomRole.ROLE_DOCTOR.getRoleName());
        Optional<ApplicationUser> user = userRepository.findById(id);
        setExisting(user.isPresent());
        if (!user.isPresent())  throw new NotFoundException("Doctor is not found");
        DoctorRepresentation doctorRepresentation = DoctorRepresentation.getDoctorRepresentation((Doctor)user.get());
        return doctorRepresentation;
    }

    @Override
    public void remove() throws NotFoundException, DeletedEntityException {
        ResourceUtils.checkRole(this, CustomRole.ROLE_DOCTOR.getRoleName());
        Optional<ApplicationUser> user = userRepository.findById(id);
        setExisting(user.isPresent());
        if (!user.isPresent())  throw new NotFoundException("Doctor is not found");
        userRepository.deletePersistentInstance(user.get());
    }
}
