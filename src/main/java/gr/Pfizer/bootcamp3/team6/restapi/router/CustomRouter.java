package gr.Pfizer.bootcamp3.team6.restapi.router;

import gr.Pfizer.bootcamp3.team6.restapi.resource.PingServerResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.impl.DoctorListResourceImpl;
import gr.Pfizer.bootcamp3.team6.restapi.resource.impl.DoctorResourceImpl;
import gr.Pfizer.bootcamp3.team6.restapi.resource.impl.PatientListResourceImpl;
import gr.Pfizer.bootcamp3.team6.restapi.resource.impl.PatientResourceImpl;
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
        router.attach("/patient/{id}/", PatientResourceImpl.class);
        router.attach("/patient", PatientListResourceImpl.class);
        router.attach("/patient/", PatientListResourceImpl.class);




        //router.attach("/doctor/id/patients ", DoctorListResourceImpl.class);
        router.attach("/doctor", DoctorListResourceImpl.class);
        router.attach("/doctor/{id}", DoctorResourceImpl.class);


        return router;
    }

    public Router publicResources() {
        Router router = new Router();
        router.attach("/ping", PingServerResource.class);
        return router;
    }


}