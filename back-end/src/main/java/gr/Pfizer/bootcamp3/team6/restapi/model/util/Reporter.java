package gr.Pfizer.bootcamp3.team6.restapi.model.util;

import gr.Pfizer.bootcamp3.team6.restapi.model.*;
import gr.Pfizer.bootcamp3.team6.restapi.model.interfaces.Measurement;
import org.apache.commons.lang3.time.DateUtils;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reporter {
    public static double getGlucoseAverageReport(List<Glucose> glucoseMeasurements, Date startDate, Date endDate)
    {
        List<Measurement> neededMeasurements = getNeededMeasurements(glucoseMeasurements,startDate,endDate);
        return getGlucoseAverage(neededMeasurements);
    }

    public static double getCarbAverageReport(List<Carb> carbMeasurements, Date startDate, Date endDate)
    {
        List<Measurement> neededMeasurements = getNeededMeasurements(carbMeasurements,startDate,endDate);
        return getCarbAverage(neededMeasurements);
    }

    public static List<ApplicationUser> getInactivePatients(List<ApplicationUser> allUsers, Date startDate, Date endDate)
    {
        return allUsers.stream().filter(user -> checkIfPatientInactive(user,startDate,endDate)).collect(Collectors.toList());
    }

    public static List<ApplicationUser> getInactiveDoctors(List<ApplicationUser> allUsers, Date startDate, Date endDate)
    {
        return allUsers.stream().filter(user -> checkIfDoctorInactive(user,startDate,endDate)).collect(Collectors.toList());
    }

    public static int getActivityForPatient(ApplicationUser user, Date startDate, Date endDate)
    {
        if(checkIfPatientInactive(user,startDate,endDate))
            return 0;
        else
        {
            List<Measurement> patientMeasurements = getAllPatientMeasurements(user);
            patientMeasurements = getNeededMeasurements(patientMeasurements,startDate,endDate);
            return patientMeasurements.size();
        }
    }

    public static int getActivityForDoctor(ApplicationUser user, Date startDate, Date endDate)
    {
        if(checkIfDoctorInactive(user,startDate,endDate))
            return 0;
        else
        {
            List<Patient> doctorPatients = ((Doctor)user).getListOfPatients();
            List<Consultation> allConsultations = new ArrayList<>();

            doctorPatients.forEach(patient -> allConsultations.addAll(patient.getListOfConsultations()));
            List<Consultation> neededConsultations = allConsultations.stream()
                    .filter(consultation -> startDate.before(consultation.getDateCreated()) && endDate.after(consultation.getDateCreated()))
                    .collect(Collectors.toList());

            return neededConsultations.size();
        }
    }

    // utility methods
    private static <T extends Measurement> List<Measurement> getNeededMeasurements(List<T> measurements, Date startDate, Date endDate)
    {
        List<Measurement> neededMeasurements = new ArrayList<>();

        measurements.forEach(measurement->{
            if(startDate.before(measurement.getDateMeasured()) && endDate.after(measurement.getDateMeasured())) {
                neededMeasurements.add(measurement);
            }
        });

        return neededMeasurements;
    }

    private static <T extends Measurement> double getGlucoseAverage(List<T> glucoseMeasurements)
    {
        // the measurements need to be sorted according to the date that they were taken, so that the below algorithm can be applied.
        Collections.sort(glucoseMeasurements, (x, y) -> x.getDateMeasured().compareTo(y.getDateMeasured()));

        double sumGlucose = 0;
        int numberOfMeasurementsForDay = 0;
        double averageForDay = 0;
        Date dateOfMeasurement = null;
        List<Double> dailyAverages = new ArrayList<>();
        double sumOfAllAverages = 0;

        for (Measurement measurement: glucoseMeasurements)
        {
            if(dateOfMeasurement == null)
            {
                dateOfMeasurement = measurement.getDateMeasured();
                sumGlucose += measurement.getMeasurementData();
                numberOfMeasurementsForDay++;
                continue;
            }

            if (!DateUtils.isSameDay(dateOfMeasurement, measurement.getDateMeasured())) {
                dateOfMeasurement = measurement.getDateMeasured();
                averageForDay = sumGlucose / numberOfMeasurementsForDay;
                dailyAverages.add(averageForDay);

                sumGlucose = 0;
                numberOfMeasurementsForDay = 0;
                averageForDay = 0;
            }
            sumGlucose += measurement.getMeasurementData();
            numberOfMeasurementsForDay++;
        }
        // calculations for the last day
        averageForDay = sumGlucose/numberOfMeasurementsForDay;
        dailyAverages.add(averageForDay);

        sumOfAllAverages = dailyAverages.stream().mapToDouble(a -> a).sum();

        return sumOfAllAverages/dailyAverages.size();
    }

    private static <T extends Measurement> double getCarbAverage(List<T> carbMeasurements)
    {
        double sumCarbIntake = carbMeasurements.stream().mapToDouble(measurement -> measurement.getMeasurementData()).sum();
        return sumCarbIntake/carbMeasurements.size();
    }

    private static boolean checkIfPatientInactive(ApplicationUser user, Date startDate, Date endDate)
    {
        List<Measurement> allPatientMeasurements = getAllPatientMeasurements(user);

        if(allPatientMeasurements.size() == 0)
            return true;

        List<Measurement> neededMeasurements = getNeededMeasurements(allPatientMeasurements,startDate,endDate);

        if(neededMeasurements.size() == 0)
            return true;

        return false;
    }

    private static boolean checkIfDoctorInactive(ApplicationUser user, Date startDate, Date endDate)
    {
        Doctor doctor = (Doctor) user;
        List<Patient> patients = doctor.getListOfPatients();
        if(patients.size() == 0)
            return true;
        else
            return patients.stream().noneMatch(patient -> startDate.before(Date.from(patient.getLastConsultedOrSignedUp().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                    && endDate.after(Date.from(patient.getLastConsultedOrSignedUp().atStartOfDay(ZoneId.systemDefault()).toInstant())));
    }

    private static List<Measurement> getAllPatientMeasurements(ApplicationUser user)
    {
        Patient patient = (Patient) user;
        return Stream.concat(patient.getListOfCarbMeasurements().stream()
                , patient.getListOfGlucoseMeasurements().stream()).collect(Collectors.toList());
    }
}