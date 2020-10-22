package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.DoctorRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface DoctorResource {
    //anaferetai sto patientrepresentation

    //epistrefei
    @Get("json")
    public DoctorRepresentation getDoctor() throws NotFoundException;

    //diagrafei
    @Delete
    public void remove() throws NotFoundException;

    //kanei add
    @Put("json")
    public DoctorRepresentation update(DoctorRepresentation doctorReprIn)
            throws NotFoundException, BadEntityException;
}
