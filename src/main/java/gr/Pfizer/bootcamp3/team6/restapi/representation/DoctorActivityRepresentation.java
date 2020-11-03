package gr.Pfizer.bootcamp3.team6.restapi.representation;

import lombok.Data;
import java.util.Date;

@Data
public class DoctorActivityRepresentation {
    private long doctorId;
    private Date currentDate;
    private double numberOfConsultations;
    private String uri;

    public void setDoctorId(long doctorId)
    {
        this.doctorId = doctorId;
        uri = "http://localhost:9000/SacchonApp/patients/" + doctorId;
    }
}
