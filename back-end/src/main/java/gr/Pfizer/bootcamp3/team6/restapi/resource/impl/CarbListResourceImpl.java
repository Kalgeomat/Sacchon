package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Carb;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.CarbRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.UserRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.CarbRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.CarbListResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CarbListResourceImpl extends ServerResource implements CarbListResource {
    private CarbRepository carbRepository;
    private UserRepository userRepository;
    private EntityManager em;
    private long patientId;

    @Override
    protected void doInit() throws ResourceException {
        try {
            em = JpaUtil.getEntityManager();
            carbRepository = new CarbRepository(em);
            userRepository = new UserRepository(em);
            patientId = Long.parseLong(getAttribute("id")); // takes the "id" from the path and transforms it to long
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
    public CarbRepresentation add(CarbRepresentation carbRepresentation) throws BadEntityException, DeletedEntityException {
        ResourceUtils.checkRole(this, CustomRole.ROLE_PATIENT.getRoleName());
        if (carbRepresentation == null) throw new  BadEntityException("Null carb representation error");

        Carb carb = CarbRepresentation.getCarb(carbRepresentation);

        Patient patientOfCarb = (Patient) userRepository.findById(patientId).get();
        patientOfCarb.addCarbMeasurement(carb);
        carbRepository.save(carb);

        return CarbRepresentation.getCarbRepresentation(carb);
    }
    @Override
    public List<CarbRepresentation> getCarbs(){

        List<String> roles = new ArrayList<>();
        roles.add(CustomRole.ROLE_PATIENT.getRoleName());
        roles.add(CustomRole.ROLE_DOCTOR.getRoleName());
        ResourceUtils.checkRoles(this, roles);
        Patient patientOfCarbs = (Patient) userRepository.findById(patientId).get();
        List<Carb> carbs= patientOfCarbs.getListOfCarbMeasurements();
        List<CarbRepresentation> carbRepresentationList = new ArrayList<>();
        carbs.forEach(carb -> carbRepresentationList.add(CarbRepresentation.getCarbRepresentation(carb)));

        return carbRepresentationList;
    }


}

