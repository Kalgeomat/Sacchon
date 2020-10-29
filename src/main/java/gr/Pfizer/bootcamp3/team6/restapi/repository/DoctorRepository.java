package gr.Pfizer.bootcamp3.team6.restapi.repository;

import gr.Pfizer.bootcamp3.team6.restapi.model.Doctor;
import gr.Pfizer.bootcamp3.team6.restapi.repository.lib.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class DoctorRepository extends Repository<Doctor,Long> {

    public DoctorRepository(EntityManager entityManager) {

        super(entityManager);
    }


    @Override
    public Class getEntityClass() {
        return Doctor.class;
    }

    @Override
    public String getEntityClassName() {
        return Doctor.class.getName();
    }

    @Override
    protected boolean checkIfDeleted(Doctor doctor) {
        return false;
    }

    @Override
    protected void deleteEntity(Doctor doctor) {

    }

    @Override
    protected List<Doctor> retrieveOnlyActive(List<Doctor> allEntities) {
        return null;
    }
}
