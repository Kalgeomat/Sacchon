package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientActivityRepresentation;
import org.restlet.resource.Get;

public interface PatientActivityResource {
    @Get("json")
    PatientActivityRepresentation getPatientActivity() throws NotFoundException;
}
