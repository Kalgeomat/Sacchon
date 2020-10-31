package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.model.Glucose;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.model.util.Reporter;
import gr.Pfizer.bootcamp3.team6.restapi.repository.GlucoseRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.PatientRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.GlucoseStatisticsRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.GlucoseStatisticsResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GlucoseStatisticsResourceImpl extends ServerResource implements GlucoseStatisticsResource {
    private GlucoseRepository glucoseRepository;
    private PatientRepository patientRepository;
    private EntityManager em;
    private long patientId;
    private Date startDate;
    private Date endDate;

    @Override
    protected void doInit() throws ResourceException {
        try {
            em = JpaUtil.getEntityManager();
            glucoseRepository = new GlucoseRepository(em);
            patientRepository = new PatientRepository(em);
            patientId = Long.parseLong(getAttribute("id")); // takes the "id" from the path and transforms it to long
            System.out.println("Test ody" + new Date(Long.parseLong(getAttribute("startDate"))));
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
    public GlucoseStatisticsRepresentation getGlucoseStatistics() {
        ResourceUtils.checkRole(this, CustomRole.ROLE_PATIENT.getRoleName());

        Patient patientOfGlucose = patientRepository.findById(patientId).get();
        List<Glucose> glucoseMeasurements = patientOfGlucose.getListOfGlucoseMeasurements();
        double glucoseAverage = Reporter.getGlucoseAverageReport(glucoseMeasurements, startDate, endDate);

        GlucoseStatisticsRepresentation glucoseStatRep = new GlucoseStatisticsRepresentation();
        glucoseStatRep.setPatientId(patientId);
        glucoseStatRep.setStartDate(startDate);
        glucoseStatRep.setEndDate(endDate);
        glucoseStatRep.setGlucoseStatistics(glucoseAverage);

        return glucoseStatRep;
    }
}
