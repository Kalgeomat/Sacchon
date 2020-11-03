package gr.Pfizer.bootcamp3.team6.restapi.representation;

import lombok.Data;
import java.util.Date;

@Data
public class PatientActivityRepresentation {
    private long patientId;
    private Date currentDate;
    private double numberOfMeasurements;
    private String uri;

    public void setPatientId(long patientId)
    {
        this.patientId = patientId;
        uri = "http://localhost:9000/SacchonApp/patients/" + patientId;
    }
}
