package gr.Pfizer.bootcamp3.team6.restapi.model.interfaces;

import java.util.Date;

public interface Measurement {
    Date getDateMeasured();
    double getMeasurementData();
}