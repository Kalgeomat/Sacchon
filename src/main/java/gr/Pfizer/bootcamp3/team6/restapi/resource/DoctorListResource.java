package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.DoctorRepresentation;

import org.restlet.resource.Get;
import org.restlet.resource.Post;

import java.util.List;

public interface DoctorListResource {

    @Post("json")
    DoctorRepresentation add(DoctorRepresentation doctorIn)
            throws BadEntityException, DeletedEntityException;
    @Get("json")
    List<DoctorRepresentation> getDoctors();
}
