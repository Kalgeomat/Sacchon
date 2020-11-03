package gr.Pfizer.bootcamp3.team6.restapi.representation;

import lombok.Data;
import java.util.Date;

@Data
public class CarbsStatisticsRepresentation {
    private long patientId;
    private Date startDate;
    private Date endDate;
    private double carbsStatistics;
    private String uri;

    public void setPatientId(long patientId)
    {
        this.patientId = patientId;
        uri = "http://localhost:9000/SacchonApp/patients/" + patientId;
    }
}
