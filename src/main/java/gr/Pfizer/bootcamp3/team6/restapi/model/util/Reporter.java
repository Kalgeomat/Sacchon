package gr.Pfizer.bootcamp3.team6.restapi.model.util;

import gr.Pfizer.bootcamp3.team6.restapi.model.*;
import gr.Pfizer.bootcamp3.team6.restapi.model.interfaces.Measurement;
import org.apache.commons.lang3.time.DateUtils;
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
        return allUsers.stream().filter(user -> checkIfPatientActive(user,startDate,endDate)).collect(Collectors.toList());
    }
    public static List<ApplicationUser> getInactiveDoctors(List<ApplicationUser> allUsers, Date startDate, Date endDate)
    {
        return allUsers.stream().filter(user -> checkIfDoctorActive(user,startDate,endDate)).collect(Collectors.toList());
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

    private static boolean checkIfPatientActive(ApplicationUser user, Date startDate, Date endDate)
    {
        Patient patient = (Patient) user;
        List<Measurement> allPatientMeasurements = Stream.concat(patient.getListOfCarbMeasurements().stream()
                , patient.getListOfGlucoseMeasurements().stream()).collect(Collectors.toList());

        if(allPatientMeasurements.size() == 0)
            return true;


        List<Measurement> neededMeasurements = getNeededMeasurements(allPatientMeasurements,startDate,endDate);

        if(neededMeasurements.size() == 0)
            return true;

        return false;
    }
}
    private static boolean checkIfDoctorActive(ApplicationUser user, Date startDate, Date endDate)
    {

    }
}