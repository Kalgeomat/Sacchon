package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Doctor;
import gr.Pfizer.bootcamp3.team6.restapi.repository.UserRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.DoctorRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.DoctorSignUpResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;

public class DoctorSignUpResourceImpl extends ServerResource implements DoctorSignUpResource {
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
    public DoctorRepresentation signUp(DoctorRepresentation doctorRepresentation) throws BadEntityException {
        if(doctorRepresentation == null) throw new BadEntityException("Null patient representation error");
        ResourceUtils.checkRole(this, CustomRole.ROLE_CHIEF_DOCTOR.getRoleName());

        Doctor doctor = doctorRepresentation.getDoctor(doctorRepresentation);
        doctor.setActive(true);
        userRepository.save(doctor);

        return DoctorRepresentation.getDoctorRepresentation(doctor);
    }
}
