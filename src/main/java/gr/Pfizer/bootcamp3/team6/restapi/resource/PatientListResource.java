package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;

import org.restlet.resource.Get;
import org.restlet.resource.Post;

import java.util.List;

public interface PatientListResource {

    @Post("json")
    public PatientRepresentation add(PatientRepresentation patientIn)
            throws BadEntityException;
    @Get("json")
    public List<PatientRepresentation> getCustomers() throws NotFoundException;
}
