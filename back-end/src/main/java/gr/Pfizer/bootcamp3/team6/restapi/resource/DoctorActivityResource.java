package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.DoctorActivityRepresentation;
import org.restlet.resource.Get;

public interface DoctorActivityResource {
    @Get
    DoctorActivityRepresentation getDoctorActivity() throws NotFoundException;
}
