package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientIneedRepresentation;
import org.restlet.resource.Get;
import java.util.List;

public interface DoctorPatientNeedResource {

    @Get("json")
    List<PatientIneedRepresentation> getDoctorPatientsNeed() throws NotFoundException;
}
