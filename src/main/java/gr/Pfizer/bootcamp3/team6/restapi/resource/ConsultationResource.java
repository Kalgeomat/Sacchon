package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Consultation;
import gr.Pfizer.bootcamp3.team6.restapi.representation.ConsultationRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.representation.DoctorRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface ConsultationResource {
    @Get("json")
    public ConsultationRepresentation getConsultation() throws NotFoundException;

    @Put("json")
    ConsultationRepresentation update(ConsultationRepresentation consultationRepresentation)
            throws NotFoundException, BadEntityException;

    @Delete
    public void remove() throws NotFoundException;

}
