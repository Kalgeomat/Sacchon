package gr.Pfizer.bootcamp3.team6.restapi.representation;

import gr.Pfizer.bootcamp3.team6.restapi.model.Carb;
import lombok.Data;
import java.util.Date;

@Data
public class CarbRepresentation {
    private long id;
    private double carbInTake;
    private Date dateMeasured;
    private long patientId;
    private String uri;

    static public Carb getCarb(CarbRepresentation carbRepresentation){
        Carb carb = new Carb();

        carb.setCarbInTake(carbRepresentation.getCarbInTake());
        carb.setDateMeasured(carbRepresentation.getDateMeasured());

        return carb;
    }

    static public CarbRepresentation  getCarbRepresentation(Carb carb){
        CarbRepresentation  carbRepresentation  = new CarbRepresentation();

        carbRepresentation.setId(carb.getId());
        carbRepresentation.setCarbInTake(carb.getCarbInTake());
        carbRepresentation.setDateMeasured(carb.getDateMeasured());
        carbRepresentation.setPatientId(carb.getPatient().getId());
        carbRepresentation.setUri("http://localhost:9000/SacchonApp/carbs/" + carb.getId());

        return carbRepresentation;
    }
}