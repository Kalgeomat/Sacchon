package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.ApplicationUserRepresentation;
import org.restlet.resource.Post;

public interface LoginResource {
    @Post()
    ApplicationUserRepresentation login() throws NotFoundException;
}
