package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;
import org.restlet.resource.Get;

import java.util.List;

public interface DoctorPatientsListResource {

    @Get("json")
    public List<PatientRepresentation> getDoctorPatients() throws NotFoundException;
}
