package gr.Pfizer.bootcamp3.team6.restapi.repository;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.lib.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class PatientRepository extends Repository<Patient,Long>{

    public PatientRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class getEntityClass() {
        return Patient.class;
    }

    @Override
    public String getEntityClassName() {
        return Patient.class.getName();
    }

    @Override
    protected boolean checkIfDeleted(Patient patient) {
        return !patient.checkIfActive();
    }

    @Override
    protected void deleteEntity(Patient patient) throws DeletedEntityException {
        patient.setActive(false);
        save(patient);
    }

    @Override
    protected List<Patient> retrieveOnlyActive(List<Patient> allEntities) {
        return allEntities.stream().filter(patient -> patient.checkIfActive()).collect(Collectors.toList());
    }
}
