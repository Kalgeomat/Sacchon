package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.DoctorRepresentation;
import org.restlet.resource.Post;

public interface DoctorSignUpResource {
    @Post("json")
    DoctorRepresentation signUp(DoctorRepresentation doctorRepresentation) throws BadEntityException;
}
