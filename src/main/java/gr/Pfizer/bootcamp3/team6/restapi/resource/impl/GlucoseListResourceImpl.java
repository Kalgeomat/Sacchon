package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Glucose;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.GlucoseRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.UserRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.GlucoseRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.GlucoseListResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class GlucoseListResourceImpl extends ServerResource implements GlucoseListResource {
    private GlucoseRepository glucoseRepository;
    private UserRepository userRepository;
    private EntityManager em;
    private long patientId;

    @Override
    protected void doInit() throws ResourceException {
        try {
            em = JpaUtil.getEntityManager();
            glucoseRepository = new GlucoseRepository(em);
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
    public GlucoseRepresentation add(GlucoseRepresentation glucoseRepresentation) throws BadEntityException, DeletedEntityException {
        ResourceUtils.checkRole(this, CustomRole.ROLE_PATIENT.getRoleName());
        if (glucoseRepresentation == null) throw new  BadEntityException("Null glucose representation error");

        Glucose glucose = GlucoseRepresentation.getGlucose(glucoseRepresentation);

        Patient patientOfGlucose = (Patient) userRepository.findById(patientId).get();
        patientOfGlucose.addGlucoseMeasurement(glucose);
        glucoseRepository.save(glucose);

        return GlucoseRepresentation.getGlucoseRepresentation(glucose);
    }


    @Override
    public List<GlucoseRepresentation> getGlucose(){
        List<String> roles = new ArrayList<>();
        roles.add(CustomRole.ROLE_PATIENT.getRoleName());
        roles.add(CustomRole.ROLE_DOCTOR.getRoleName());
        ResourceUtils.checkRoles(this, roles);

        Patient patientOfGlucose = (Patient) userRepository.findById(patientId).get();
        List<Glucose> glucoseMeasurements = patientOfGlucose.getListOfGlucoseMeasurements();
        List<GlucoseRepresentation>  glucoseRepresentationList = new ArrayList<>();
        glucoseMeasurements.forEach(glucose -> glucoseRepresentationList.add(GlucoseRepresentation.getGlucoseRepresentation(glucose)));

        return glucoseRepresentationList;
    }
}