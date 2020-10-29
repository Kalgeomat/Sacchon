package gr.Pfizer.bootcamp3.team6.restapi.repository;

import gr.Pfizer.bootcamp3.team6.restapi.model.Patient;
import gr.Pfizer.bootcamp3.team6.restapi.repository.lib.Repository;

import javax.persistence.EntityManager;

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
        return false;
    }

    @Override
    protected void deleteEntity(Patient patient) {

    }
}
