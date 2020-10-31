package gr.Pfizer.bootcamp3.team6.restapi.representation;


import gr.Pfizer.bootcamp3.team6.restapi.model.Glucose;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class GlucoseRepresentation {
        private long id;
        private double bloodGlucoseLevel;
        private Date dateMeasured;
        private long patientId;
        private String uri;

        static public Glucose getGlucose(GlucoseRepresentation glucoseRepresentation){
            Glucose glucose = new Glucose();

            glucose.setBloodGlucoseLevel(glucoseRepresentation.getBloodGlucoseLevel());
            glucose.setDateMeasured(glucoseRepresentation.getDateMeasured());

            return glucose;
        }

        static public GlucoseRepresentation  getGlucoseRepresentation(Glucose glucose){
            GlucoseRepresentation  glucoseRepresentation  = new GlucoseRepresentation();

            glucoseRepresentation.setId(glucose.getId());
            glucoseRepresentation.setBloodGlucoseLevel(glucose.getBloodGlucoseLevel());
            glucoseRepresentation.setDateMeasured(glucose.getDateMeasured());
            glucoseRepresentation.setPatientId(glucose.getPatient().getId());
            glucoseRepresentation.setUri("http://localhost:9000/SacchonApp/glucose/"+glucose.getId());

            return glucoseRepresentation;
        }
}