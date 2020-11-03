package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.GlucoseRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface GlucoseResource {

    @Get("json")
    GlucoseRepresentation getGlucose() throws NotFoundException, DeletedEntityException;

    @Delete
    void remove() throws NotFoundException, DeletedEntityException;

    @Put("json")
    GlucoseRepresentation update(GlucoseRepresentation glucoseReprIn)
            throws NotFoundException, BadEntityException;
}
