package gr.Pfizer.bootcamp3.team6.restapi.resource.impl;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.BadEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.model.ChiefDoctor;
import gr.Pfizer.bootcamp3.team6.restapi.model.Gender;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.UserRepository;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.representation.PatientRepresentation;
import gr.Pfizer.bootcamp3.team6.restapi.resource.PatientSignUpResource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import javax.persistence.EntityManager;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Date;

public class PatientSignUpResourceImpl extends ServerResource implements PatientSignUpResource {
    private UserRepository userRepository;
    private EntityManager em;

    @Override
    protected void doInit() throws ResourceException {
        try {
            em = JpaUtil.getEntityManager();
            userRepository = new UserRepository(em);
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
    public PatientRepresentation signUp(PatientRepresentation patientRepresentation) throws BadEntityException {
        if (patientRepresentation==null) throw new BadEntityException("Null patient representation error");

        Patient patient = PatientRepresentation.getPatient(patientRepresentation);
        patient.setActive(true);
        patient.setLastConsultedOrSignedUp(LocalDate.now(Clock.systemUTC()));
        userRepository.save(patient);
        
        /*ChiefDoctor chiefDoctor = new ChiefDoctor();
        chiefDoctor.setUsername("admin");
        chiefDoctor.setPassword("admin57");
        chiefDoctor.setFirstName("John");
        chiefDoctor.setLastName("John");
        chiefDoctor.setAddress("Athens");
        chiefDoctor.setDob(new Date());
        chiefDoctor.setEmail("test@mail.com");
        chiefDoctor.setGender(Gender.MALE);
        chiefDoctor.setActive(true);
        chiefDoctor.setTelephoneNumber(5577);
        userRepository.save(chiefDoctor);*/

        return PatientRepresentation.getPatientRepresentation(patient);
    }
}