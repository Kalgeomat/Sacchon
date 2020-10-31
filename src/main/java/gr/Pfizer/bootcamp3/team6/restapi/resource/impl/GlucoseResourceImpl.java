package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Glucose;
import gr.Pfizer.bootcamp3.team6.restapi.repository.GlucoseRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.GlucoseRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.GlucoseResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GlucoseResourceImpl extends ServerResource implements GlucoseResource {


    private GlucoseRepository glucoseRepository ;
    private EntityManager em;
    private long glucoseId;

    @Override
    protected void doInit() {
        try {
            em = JpaUtil.getEntityManager();
            glucoseRepository = new GlucoseRepository(em);
            glucoseId= Long.parseLong(getAttribute("id"));
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
    public GlucoseRepresentation getGlucose() throws NotFoundException, ResourceException, DeletedEntityException {

        List<String> roles = new ArrayList<>();
        roles.add(CustomRole.ROLE_PATIENT.getRoleName());
        roles.add(CustomRole.ROLE_DOCTOR.getRoleName());
        ResourceUtils.checkRoles(this, roles);
        Optional<Glucose> glucose= glucoseRepository.findById(glucoseId);
        setExisting(glucose.isPresent());
        if (!glucose.isPresent())  throw new NotFoundException("Glucose is not found");
        GlucoseRepresentation glucoseRepresentation = GlucoseRepresentation.getGlucoseRepresentation(glucose.get());

        return glucoseRepresentation;
    }


    @Override
    public void remove() throws NotFoundException, DeletedEntityException {

        ResourceUtils.checkRole(this, CustomRole.ROLE_PATIENT.getRoleName());
        Optional<Glucose> glucoseRemove = glucoseRepository.findById(glucoseId);
        setExisting(glucoseRemove.isPresent());
        if (!glucoseRemove.isPresent())  throw new NotFoundException("Glucose is not found");
        glucoseRepository.deleteById(glucoseId);

    }

    @Override
    public GlucoseRepresentation update(GlucoseRepresentation glucoseReprIn) throws NotFoundException, BadEntityException {
        ResourceUtils.checkRole(this, CustomRole.ROLE_PATIENT.getRoleName());
        if (glucoseReprIn == null) throw new  BadEntityException("Null glucose representation error");

        Glucose newGlucose = GlucoseRepresentation.getGlucose(glucoseReprIn);
        Optional<Glucose> glucoseToUpdateOptional = glucoseRepository.findById(glucoseId);
        setExisting(glucoseToUpdateOptional.isPresent());
        if (!glucoseToUpdateOptional.isPresent())  throw new NotFoundException("Glucose is not found");
        Glucose glucoseToUpdate = glucoseToUpdateOptional.get();

        // this is where the glucose is updated in the application
        glucoseToUpdate.setBloodGlucoseLevel(newGlucose.getBloodGlucoseLevel());
        glucoseToUpdate.setDateMeasured(newGlucose.getDateMeasured());

        // this where the glucose is updated in the database
        glucoseRepository.save(glucoseToUpdate);

        return GlucoseRepresentation.getGlucoseRepresentation(glucoseToUpdate);
    }
}