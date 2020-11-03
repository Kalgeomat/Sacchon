package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.ConsultationRepresentation;

import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface ConsultationResource {
    @Get("json")
    ConsultationRepresentation getConsultation() throws NotFoundException, DeletedEntityException;

    @Put("json")
    ConsultationRepresentation update(ConsultationRepresentation consultationRepresentation)
            throws NotFoundException, BadEntityException;
}
