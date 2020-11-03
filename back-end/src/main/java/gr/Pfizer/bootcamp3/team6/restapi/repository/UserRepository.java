package gr.Pfizer.bootcamp3.team6.restapi.repository;

import gr.Pfizer.bootcamp3.team6.restapi.exceptions.DeletedEntityException;
import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.repository.lib.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository extends Repository<ApplicationUser,Long> {
    public UserRepository(EntityManager entityManager)
    {
        super(entityManager);
    }

    @Override
    public Class<ApplicationUser> getEntityClass() {
        return ApplicationUser.class;
    }

    @Override
    public String getEntityClassName() {
        return ApplicationUser.class.getName();
    }

    @Override
    protected boolean checkIfDeleted(ApplicationUser applicationUser) {
        return !applicationUser.checkIfActive();
    }

    @Override
    protected void deleteEntity(ApplicationUser applicationUser) throws DeletedEntityException {
        applicationUser.setActive(false);
        save(applicationUser);
    }

    @Override
    protected List<ApplicationUser> retrieveOnlyActive(List<ApplicationUser> allEntities) {
        return allEntities.stream().filter(user -> user.checkIfActive()).collect(Collectors.toList());
    }
}