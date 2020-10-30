package gr.Pfizer.bootcamp3.team6.restapi.repository;

import gr.Pfizer.bootcamp3.team6.restapi.model.Carb;
import gr.Pfizer.bootcamp3.team6.restapi.repository.lib.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

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
        return !carb.checkIfActive();
    }

    @Override
    protected void deleteEntity(Carb carb) {
        carb.setActive(false);
        save(carb);

    }

    @Override
    protected List<Carb> retrieveOnlyActive(List<Carb> allEntities) {
        return allEntities.stream().filter(carb -> carb.checkIfActive()).collect(Collectors.toList());
    }
}
