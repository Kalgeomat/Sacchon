package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.model.Doctor;
import gr.Pfizer.bootcamp3.team6.restapi.repository.UserRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.DoctorRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.DoctorListResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorListResourceImpl extends ServerResource implements DoctorListResource {
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
    public DoctorRepresentation add(DoctorRepresentation doctorIn) throws BadEntityException {

        ResourceUtils.checkRole(this, CustomRole.ROLE_CHIEF_DOCTOR.getRoleName());
        if (doctorIn==null) throw new  BadEntityException("Null doctor representation error");
        //if (doctorIn.getLastName().equals("admin")) throw new  BadEntityException("Invalid doctor name error");

        Doctor doctor = DoctorRepresentation.getDoctor(doctorIn);
        doctor.setActive(true);
        userRepository.save(doctor);

        return DoctorRepresentation.getDoctorRepresentation(doctor);
    }

    @Override
    public List<DoctorRepresentation> getDoctors() {
        ResourceUtils.checkRole(this, CustomRole.ROLE_CHIEF_DOCTOR.getRoleName());
        List<ApplicationUser> users= userRepository.findAll();
        // retrieve only the ones that are doctors
        List<ApplicationUser> doctors = users.stream().filter(user -> user instanceof Doctor).collect(Collectors.toList());

        List<DoctorRepresentation> doctorRepresentationList = new ArrayList<>();
        doctors.forEach(user -> doctorRepresentationList.add(DoctorRepresentation.getDoctorRepresentation((Doctor) user)));

        return doctorRepresentationList;
    }
}