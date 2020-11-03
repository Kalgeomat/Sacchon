package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;
import org.restlet.resource.Post;

public interface PatientSignUpResource {
    @Post("json")
    PatientRepresentation signUp(PatientRepresentation patientRepresentation) throws BadEntityException;
}
