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
    public void remove() throws NotFoundException {


    }

    @Override
    public void update(GlucoseRepresentation glucoseReprIn) throws NotFoundException, BadEntityException {

    }


}