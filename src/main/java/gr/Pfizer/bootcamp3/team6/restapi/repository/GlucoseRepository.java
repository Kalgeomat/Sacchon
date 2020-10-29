package gr.Pfizer.bootcamp3.team6.restapi.repository;

import gr.Pfizer.bootcamp3.team6.restapi.model.Carb;
import gr.Pfizer.bootcamp3.team6.restapi.model.Glucose;
import gr.Pfizer.bootcamp3.team6.restapi.repository.lib.Repository;

import javax.persistence.EntityManager;
import java.util.List;

public class GlucoseRepository extends Repository<Glucose, Long> {

    public GlucoseRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Glucose> getEntityClass() {
        return Glucose.class;
    }

    @Override
    public String getEntityClassName() {
        return Glucose.class.getName();
    }

    @Override
    protected boolean checkIfDeleted(Glucose glucose) {
        return false;
    }

    @Override
    protected void deleteEntity(Glucose glucose) {

    }

    @Override
    protected List<Glucose> retrieveOnlyActive(List<Glucose> allEntities) {
        return null;
    }
}