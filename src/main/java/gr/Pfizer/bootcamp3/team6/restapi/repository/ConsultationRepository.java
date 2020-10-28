package gr.Pfizer.bootcamp3.team6.restapi.repository;

import gr.Pfizer.bootcamp3.team6.restapi.model.Consultation;
import gr.Pfizer.bootcamp3.team6.restapi.repository.lib.Repository;

import javax.persistence.EntityManager;

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
}