package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.DoctorPatientsListResource;
import org.restlet.resource.ServerResource;

import java.util.List;

public class DoctorPatientsListResourceImpl extends ServerResource implements DoctorPatientsListResource {

    @Override
    public List<PatientRepresentation> getDoctorPatients() throws NotFoundException {
        return null;
    }


}
