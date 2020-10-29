package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.CarbRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.representation.ConsultationRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

import java.util.List;

public interface CarbListResource {

    @Post("json")
    CarbRepresentation add(CarbRepresentation carbRepresentation)
            throws BadEntityException, DeletedEntityException;

    @Get("json")
    List<CarbRepresentation> getCarbs() throws NotFoundException;
}
