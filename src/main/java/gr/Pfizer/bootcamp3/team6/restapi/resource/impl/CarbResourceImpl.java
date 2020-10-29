package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Carb;
import gr.Pfizer.bootcamp3.team6.restapi.repository.CarbRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.CarbRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.CarbResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarbResourceImpl  extends ServerResource implements CarbResource {


    private CarbRepository carbRepository ;
    private EntityManager em;
    private long carbId;

    @Override
    protected void doInit() {
        try {
            em = JpaUtil.getEntityManager();
            carbRepository = new CarbRepository(em);
            carbId= Long.parseLong(getAttribute("id"));
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
    public CarbRepresentation getCarb() throws NotFoundException, ResourceException, DeletedEntityException {

        List<String> roles = new ArrayList<>();
        roles.add(CustomRole.ROLE_PATIENT.getRoleName());
        roles.add(CustomRole.ROLE_DOCTOR.getRoleName());
        ResourceUtils.checkRoles(this, roles);
        Optional<Carb> carb = carbRepository.findById(carbId);
        setExisting(carb.isPresent());
        if (!carb.isPresent())  throw new NotFoundException("Carb is not found");
        CarbRepresentation carbRepresentation = CarbRepresentation.getCarbRepresentation(carb.get());

        return carbRepresentation;
    }
    List<String> roles = new ArrayList<>();



    @Override
    public void remove() throws NotFoundException {


    }

    @Override
    public void update(CarbRepresentation carbReprIn) throws NotFoundException, BadEntityException {

    }


}


