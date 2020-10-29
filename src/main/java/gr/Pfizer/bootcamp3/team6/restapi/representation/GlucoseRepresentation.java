package gr.Pfizer.bootcamp3.team6.restapi.representation;

import gr.Pfizer.bootcamp3.team6.restapi.model.Carb;
import gr.Pfizer.bootcamp3.team6.restapi.model.Glucose;
import lombok.Data;

import java.util.Date;

@Data
public class GlucoseRepresentation {
        private long id;
        private Date creationTime;
        private double bloodGlucoseLevel;
        private Date dateMeasured;
        private long patientId;
        private String uri;

        static public Glucose getGlucose(GlucoseRepresentation glucoseRepresentation){
            Glucose glucose = new Glucose();

            glucose.setCreationTime(glucoseRepresentation.getCreationTime());
            glucose.setBloodGlucoseLevel(glucoseRepresentation.getBloodGlucoseLevel());
            glucose.setDateMeasured(glucoseRepresentation.getDateMeasured());

            return glucose;
        }

        static public GlucoseRepresentation  getGlucoseRepresentation(Glucose glucose){
            GlucoseRepresentation  glucoseRepresentation  = new GlucoseRepresentation();

            glucoseRepresentation.setId(glucose.getId());
            glucoseRepresentation.setCreationTime(glucose.getCreationTime());
            glucoseRepresentation.setBloodGlucoseLevel(glucose.getBloodGlucoseLevel());
            glucoseRepresentation.setDateMeasured(glucose.getDateMeasured());
            glucoseRepresentation.setPatientId(glucose.getPatient().getId());
            glucoseRepresentation.setUri("http://localhost:9000/SacchonApp/patients/" +glucose.getPatient().getId() + "/glucose/" + glucose.getId());

            return glucoseRepresentation;
        }
}