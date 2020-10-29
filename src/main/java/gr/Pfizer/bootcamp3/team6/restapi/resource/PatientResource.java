package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface PatientResource {
    @Get("json")
    PatientRepresentation getPatient() throws NotFoundException, DeletedEntityException;

    @Delete
    void remove() throws NotFoundException, DeletedEntityException;

    @Put("json")
    PatientRepresentation update(PatientRepresentation patientReprIn)
            throws NotFoundException, BadEntityException;
}
