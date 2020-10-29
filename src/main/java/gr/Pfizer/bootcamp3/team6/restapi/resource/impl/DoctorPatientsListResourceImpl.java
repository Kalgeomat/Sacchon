package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;


import gr.Pfizer.bootcamp3.team6.restapi.exceptions.NotFoundException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.DoctorRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.PatientRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.DoctorPatientsListResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.ResourceUtils;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class DoctorPatientsListResourceImpl extends ServerResource implements DoctorPatientsListResource {

    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;
    private EntityManager em;
    private long doctorId;

    @Override
    protected void doInit() throws ResourceException {
        try {
            em = JpaUtil.getEntityManager();
            doctorRepository = new DoctorRepository(em);
            patientRepository = new PatientRepository(em);
            doctorId = Long.parseLong(getAttribute("id")); // takes the "id" from the path and transforms it to long
        }
        catch(Exception ex){
            throw new ResourceException(ex);
        }
    }

    @Override
    protected void doRelease() throws ResourceException {
        em.close();
    }

    @Override
    public List<PatientRepresentation> getDoctorPatients() throws NotFoundException {
        ResourceUtils.checkRole(this, CustomRole.ROLE_DOCTOR.getRoleName());

        List<Patient> patients= patientRepository.findAll();
        patients = getPatientForDoctor(patients);
        List<PatientRepresentation> patientRepresentationList = new ArrayList<>();
        patients.forEach(patient ->patientRepresentationList.add(PatientRepresentation.getPatientRepresentation(patient)));

        return patientRepresentationList;
    }

    private List<Patient> getPatientForDoctor(List<Patient> allPatients)
    {
        List<Patient> doctorsPatients = new ArrayList<>();

        allPatients.forEach(patient -> {
            if(patient.getDoctor().getId() == doctorId)
                doctorsPatients.add(patient);
        });

        return  doctorsPatients;
    }
}


