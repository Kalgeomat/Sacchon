package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.model.Carb;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.model.util.Reporter;
import gr.Pfizer.bootcamp3.team6.restapi.repository.UserRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.CarbsStatisticsRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.CarbsStatisticsResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class CarbsStatisticsResourceImpl extends ServerResource implements CarbsStatisticsResource {
    private UserRepository userRepository;
    private EntityManager em;
    private long patientId;
    private Date startDate;
    private Date endDate;

    @Override
    protected void doInit() throws ResourceException {
        try {
            em = JpaUtil.getEntityManager();
            userRepository = new UserRepository(em);
            patientId = Long.parseLong(getAttribute("id")); // takes the "id" from the path and transforms it to long
            long start = Long.parseLong(getAttribute("startDate")); // takes the "startDate" from the path and transforms it to long
            long end = Long.parseLong(getAttribute("endDate")); // takes the "endDate" from the path and transforms it to long
            startDate = new Date(start);
            endDate = new Date(end);
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
    public CarbsStatisticsRepresentation getCarbsStatistics() {
        ResourceUtils.checkRole(this, CustomRole.ROLE_PATIENT.getRoleName());

        Patient patientOfCarb = (Patient) userRepository.findById(patientId).get();
        List<Carb> carbMeasurements = patientOfCarb.getListOfCarbMeasurements();
        double carbAverage = Reporter.getCarbAverageReport(carbMeasurements, startDate, endDate);

        CarbsStatisticsRepresentation carbStatRep = new CarbsStatisticsRepresentation();
        carbStatRep.setPatientId(patientId);
        carbStatRep.setStartDate(startDate);
        carbStatRep.setEndDate(endDate);
        carbStatRep.setCarbsStatistics(carbAverage);

        return carbStatRep;
    }
}
