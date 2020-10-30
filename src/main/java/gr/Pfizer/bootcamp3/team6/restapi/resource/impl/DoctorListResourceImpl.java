package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Doctor;
import gr.Pfizer.bootcamp3.team6.restapi.repository.DoctorRepository;
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

public class DoctorListResourceImpl extends ServerResource implements DoctorListResource {
    private DoctorRepository doctorRepository ;
    private EntityManager em;

    @Override
    protected void doInit() {
        try {
            em = JpaUtil.getEntityManager();
            doctorRepository = new DoctorRepository(em);

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
        doctorRepository.save(doctor);

        return DoctorRepresentation.getDoctorRepresentation(doctor);
    }

    @Override
    public List<DoctorRepresentation> getDoctors() {
        ResourceUtils.checkRole(this, CustomRole.ROLE_CHIEF_DOCTOR.getRoleName());
        List<Doctor> doctors= doctorRepository.findAll();

        List<DoctorRepresentation> doctorRepresentationList = new ArrayList<>();
        doctors.forEach(doctor -> doctorRepresentationList.add(DoctorRepresentation.getDoctorRepresentation(doctor)));

        return doctorRepresentationList;
    }
}