package gr.Pfizer.bootcamp3.team6.restapi.repository;

import gr.Pfizer.bootcamp3.team6.restapi.model.Carb;
import gr.Pfizer.bootcamp3.team6.restapi.model.Consultation;
import gr.Pfizer.bootcamp3.team6.restapi.repository.lib.Repository;
import lombok.Data;

import javax.persistence.EntityManager;
import java.util.Optional;


public class CarbRepository extends Repository<Carb, Long> {

    public CarbRepository(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Class<Carb> getEntityClass() {
        return Carb.class;
    }

    @Override
    public String getEntityClassName() {
        return Carb.class.getName();
    }

    @Override
    protected boolean checkIfDeleted(Carb carb) {
        return false;
    }

    @Override
    protected void deleteEntity(Carb carb) {

    }

}
