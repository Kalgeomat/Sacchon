package gr.Pfizer.bootcamp3.team6.restapi.router;

import gr.Pfizer.bootcamp3.team6.restapi.resource.util.DoctorResourceImpl;
import gr.Pfizer.bootcamp3.team6.restapi.resource.util.PatientResourceImpl;
import org.restlet.Application;
import org.restlet.routing.Router;

public class CustomRouter {
  //ftiaxnw ena router pou pairnei plirofories apo ena application
    private Application application;

    public CustomRouter(Application application) {
        this.application = application;

    }


    public Router createApiRouter() {

        Router router = new Router(application.getContext());

        router.attach("/patient/{id}", PatientResourceImpl.class);
        //router.attach("/customer", PatientListResourceImpl.class);
        //router.attach("/customer/", PatientListResourceImpl.class);

        router.attach("/doctor/{id}", DoctorResourceImpl.class);


        return router;
    }

//    public Router publicResources() {
//        Router router = new Router();
//        router.attach("/ping", PingServerResource.class);
//        return router;
//    }


}
