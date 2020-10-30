package gr.Pfizer.bootcamp3.team6.restapi.repository;

import gr.Pfizer.bootcamp3.team6.restapi.model.Consultation;
import gr.Pfizer.bootcamp3.team6.restapi.repository.lib.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultationRepository extends Repository<Consultation, Long> {

    public ConsultationRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Consultation> getEntityClass() {
        return Consultation.class;
    }

    @Override
    public String getEntityClassName() {
        return Consultation.class.getName();
    }

    @Override
    protected boolean checkIfDeleted(Consultation consultation) {
        return !consultation.checkIfActive();
    }

    @Override
    protected void deleteEntity(Consultation consultation) {

    }

    @Override
    protected List<Consultation> retrieveOnlyActive(List<Consultation> allEntities) {
        return allEntities.stream().filter(consultation -> consultation.checkIfActive()).collect(Collectors.toList());
    }
}
