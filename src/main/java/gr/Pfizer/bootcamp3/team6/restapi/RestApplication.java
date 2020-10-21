package gr.Pfizer.bootcamp3.team6.restapi;

import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import org.restlet.Application;
import org.restlet.engine.Engine;

import javax.persistence.EntityManager;
import java.util.logging.Logger;

public class RestApplication extends Application {

    public static final Logger LOGGER = Engine.getLogger(RestApplication.class);

    public static void main(String[] args) {


        //gia na ftiaksw tous pinakes
        EntityManager em = JpaUtil.getEntityManager();
        em.close();
    }
}
