package gr.Pfizer.bootcamp3.team6.restapi.repository;

import gr.Pfizer.bootcamp3.team6.restapi.model.Doctor;
import gr.Pfizer.bootcamp3.team6.restapi.model.Measurement;
import gr.Pfizer.bootcamp3.team6.restapi.repository.lib.Repository;

import javax.persistence.EntityManager;

public class MeasurementRepository  extends Repository<Measurement,Long> {

    public MeasurementRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class getEntityClass() {
        return Measurement.class;
    }

    @Override
    public String getEntityClassName() {
        return Measurement.class.getName();
    }
}

