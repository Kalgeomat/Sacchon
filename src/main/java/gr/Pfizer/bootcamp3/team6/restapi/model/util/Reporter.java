package gr.Pfizer.bootcamp3.team6.restapi.model.util;

import gr.Pfizer.bootcamp3.team6.restapi.model.Glucose;
import org.apache.commons.lang3.time.DateUtils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Reporter {
    public static double getGlucoseAverageReport(List<Glucose> glucoseMeasurements, Date startDate, Date endDate)
    {
        List<Glucose> neededMeasurements = getNeededMearurements(glucoseMeasurements,startDate,endDate);
        return getGlucoseAverage(neededMeasurements); // just for testing
    }

    // utility methods
    private static List<Glucose> getNeededMearurements(List<Glucose> glucoseMeasurements, Date startDate, Date endDate)
    {
        List<Glucose> neededMeasurements = new ArrayList<>();

        glucoseMeasurements.forEach(measurement->{
            if(startDate.before(measurement.getDateMeasured()) && endDate.after(measurement.getDateMeasured())) {
                neededMeasurements.add(measurement);
            }
        });

        return neededMeasurements;
    }

    private static double getGlucoseAverage(List<Glucose> glucoseMeasurements)
    {
        Collections.sort(glucoseMeasurements, (x, y) -> x.getDateMeasured().compareTo(y.getDateMeasured()));

        double sumGlucose = 0;
        int numberOfMeasurementsForDay = 0;
        double averageForDay = 0;
        Date dateOfMeasurement = null;
        List<Double> dailyAverages = new ArrayList<>();
        double sumOfAllAverages = 0;

        for (Glucose measurement: glucoseMeasurements)
        {
            if(dateOfMeasurement == null)
            {
                dateOfMeasurement = measurement.getDateMeasured();
                sumGlucose += measurement.getBloodGlucoseLevel();
                numberOfMeasurementsForDay++;
                continue;
            }

            if(DateUtils.isSameDay(dateOfMeasurement,measurement.getDateMeasured()))
            {
                sumGlucose += measurement.getBloodGlucoseLevel();
                numberOfMeasurementsForDay++;
            }
            else
            {
                dateOfMeasurement = measurement.getDateMeasured();
                averageForDay = sumGlucose/numberOfMeasurementsForDay;
                dailyAverages.add(averageForDay);

                sumGlucose = 0;
                numberOfMeasurementsForDay = 0;
                averageForDay = 0;

                sumGlucose += measurement.getBloodGlucoseLevel();
                numberOfMeasurementsForDay++;
            }
        }

        // calculations for the last day
        averageForDay = sumGlucose/numberOfMeasurementsForDay;
        dailyAverages.add(averageForDay);

        sumOfAllAverages = dailyAverages.stream().mapToDouble(a -> a).sum();

        return dailyAverages.get(0);
    }
}