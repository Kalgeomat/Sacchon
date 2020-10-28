package gr.Pfizer.bootcamp3.team6.restapi;

import gr.Pfizer.bootcamp3.team6.restapi.repository.util.JpaUtil;
import gr.Pfizer.bootcamp3.team6.restapi.resource.impl.ConsultationListResourceImpl;
import gr.Pfizer.bootcamp3.team6.restapi.router.CustomRouter;
import gr.Pfizer.bootcamp3.team6.restapi.security.CustomRole;
import gr.Pfizer.bootcamp3.team6.restapi.security.Shield;
import gr.Pfizer.bootcamp3.team6.restapi.security.cors.CustomCorsFilter;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;
import org.restlet.routing.Router;
import org.restlet.security.ChallengeAuthenticator;
import org.restlet.security.Role;

import javax.persistence.EntityManager;
import java.util.logging.Logger;

public class RestApplication extends Application {
    public static final Logger LOGGER = Engine.getLogger(RestApplication.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("Contacts application starting...");

        //initialization
        EntityManager em = JpaUtil.getEntityManager();
        em.close();

        //start up the restlet server
        Component c = new Component();
        c.getServers().add(Protocol.HTTP, 9000);
        c.getDefaultHost().attach("/SacchonApp", new RestApplication());
        c.start();

        LOGGER.info("Sacchon Web API started");
        LOGGER.info("URL: http://localhost:9000/SacchonApp/");
        LOGGER.info("URL: http://localhost:9000/SacchonApp/patients/1/consultations");
    }
    @Override
    public Restlet createInboundRoot() {
        CustomRouter customRouter = new CustomRouter(this);
        Shield shield = new Shield(this);

        Router publicRouter = customRouter.publicResources();
        ChallengeAuthenticator apiGuard = shield.createApiGuard();
        // Create the api router, protected by a guard

        Router apiRouter = customRouter.createApiRouter();
        apiGuard.setNext(apiRouter);

        publicRouter.attachDefault(apiGuard);

        // return publicRouter;

        CustomCorsFilter corsFilter = new CustomCorsFilter(this);
        return corsFilter.createCorsFilter(publicRouter);
    }

    public RestApplication() {
        setName("Sacchon");
        setDescription("Medical data web application.");

        getRoles().add(new Role(this, CustomRole.ROLE_PATIENT.getRoleName()));
        getRoles().add(new Role(this, CustomRole.ROLE_DOCTOR.getRoleName()));
        getRoles().add(new Role(this,  CustomRole.ROLE_CHIEF_DOCTOR.getRoleName()));
    }
}