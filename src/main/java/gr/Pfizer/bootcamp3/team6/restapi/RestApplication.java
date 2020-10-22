package gr.Pfizer.bootcamp3.team6.restapi;

import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.router.CustomRouter;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;
import org.restlet.routing.Router;
import org.restlet.security.ChallengeAuthenticator;

import javax.persistence.EntityManager;
import java.util.logging.Logger;

public class RestApplication extends Application {

    public static final Logger LOGGER = Engine.getLogger(RestApplication.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("Contacts application starting...");

        //arxikopoihsh
        EntityManager em = JpaUtil.getEntityManager();
        em.close();

        //ksekinaw to sugkekrimeno server pou legetai rest application
        Component c = new Component();
        c.getServers().add(Protocol.HTTP, 9000);
        c.getDefaultHost().attach("/SacchonApp", new RestApplication());
        c.start();

        LOGGER.info("Sample Web API started");
        //LOGGER.info("URL: http://localhost:9000/SacchonApp/patient/2");
        LOGGER.info("URL: http://localhost:9000/SacchonApp/doctor/1");

    }
    @Override
    public Restlet createInboundRoot() {

        CustomRouter customRouter = new CustomRouter(this);
        //Shield shield = new Shield(this);

//        Router publicRouter = customRouter.publicResources();
//        ChallengeAuthenticator apiGuard = shield.createApiGuard();
        // Create the api router, protected by a guard
//
            //  Router apiRouter = customRouter.createApiRouter();
//        apiGuard.setNext(apiRouter);
//
//        publicRouter.attachDefault(apiGuard);
//
//        // return publicRouter;
//
//        CustomCorsFilter corsFilter = new CustomCorsFilter(this);
//        return corsFilter.createCorsFilter(publicRouter);
            return customRouter.createApiRouter();

    }
}
