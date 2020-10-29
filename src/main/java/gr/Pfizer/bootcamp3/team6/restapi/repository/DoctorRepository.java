package gr.Pfizer.bootcamp3.team6.restapi.repository;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.model.Doctor;
import gr.Pfizer.bootcamp3.team6.restapi.repository.lib.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return !doctor.checkIfActive();
    }

    @Override
    protected void deleteEntity(Doctor doctor)  throws DeletedEntityException {
        doctor.setActive(false);
        save(doctor);
    }

    @Override
    protected List<Doctor> retrieveOnlyActive(List<Doctor> allEntities) {
        return allEntities.stream().filter(doctor -> doctor.checkIfActive()).collect(Collectors.toList());
    }
}
