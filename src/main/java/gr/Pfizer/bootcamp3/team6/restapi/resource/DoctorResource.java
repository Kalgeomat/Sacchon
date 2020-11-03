package gr.Pfizer.bootcamp3.team6.restapi.resource;


import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.DoctorRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;


public interface DoctorResource {


    @Get("json")
    DoctorRepresentation getDoctor() throws NotFoundException, DeletedEntityException;

    @Delete
    void remove() throws NotFoundException, DeletedEntityException;


}
