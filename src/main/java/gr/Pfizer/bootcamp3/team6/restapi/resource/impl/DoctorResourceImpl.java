package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Doctor;
import gr.Pfizer.bootcamp3.team6.restapi.repository.DoctorRepository;
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

    private DoctorRepository doctorRepository ;
    private EntityManager em;
    private long id;

    @Override
    protected void doInit() {
        try {
            em = JpaUtil.getEntityManager();
            doctorRepository = new DoctorRepository(em); //parametro pou pairnoun ta repository
            id = Long.parseLong(getAttribute("id")); //to diavazei apo to path kai to metatrepei
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
        Optional<Doctor> doctor = doctorRepository.findById(id);
        setExisting(doctor.isPresent());
        if (!doctor.isPresent())  throw new NotFoundException("Doctor is not found");
        DoctorRepresentation doctorRepresentation = DoctorRepresentation.getDoctorRepresentation(doctor.get());
        return doctorRepresentation;
    }

    @Override
    public void remove() throws NotFoundException {


    }

    @Override
    public DoctorRepresentation update(DoctorRepresentation doctorReprIn) throws NotFoundException, BadEntityException {
        return null;
    }
}
