package gr.Pfizer.bootcamp3.team6.restapi.repository.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static EntityManager getEntityManager() {

        EntityManager em = getEntityManagerFactory().createEntityManager();
        return em;
    }


    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}

