package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;
import org.restlet.resource.Get;

import java.util.List;

public interface InactiveDoctorsListResource {
    @Get("json")
    List<PatientRepresentation> getInactiveDoctors() throws NotFoundException;
}

