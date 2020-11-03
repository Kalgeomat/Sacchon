package gr.Pfizer.bootcamp3.team6.restapi.security;

import gr.Pfizer.bootcamp3.team6.restapi.model.ApplicationUser;
import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import org.restlet.Context;
import javax.persistence.NoResultException;

public class ApplicationUserPersistence {
    // Singleton pattern.
    private static ApplicationUserPersistence applicationUserPersistence = new ApplicationUserPersistence();

    private ApplicationUserPersistence() {

    }

    public static synchronized ApplicationUserPersistence getApplicationUserPersistence() {
        return applicationUserPersistence;
    }

    public ApplicationUser findById(String username) throws NoResultException{
        Context.getCurrentLogger().finer("Method findById() of ApplicationUserPersistence called.");
        ApplicationUser user = null;

        try {
            user = JpaUtil.getEntityManager().createQuery("SELECT u from ApplicationUser u WHERE u.username = :username", ApplicationUser.class).
                    setParameter("username", username).getSingleResult();
        }
        catch (NoResultException exception)
        {
            throw exception;
        }

        return user;
    }
}