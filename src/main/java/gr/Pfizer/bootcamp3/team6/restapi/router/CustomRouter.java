package gr.Pfizer.bootcamp3.team6.restapi.router;

import gr.Pfizer.bootcamp3.team6.restapi.resource.PingServerResource;
import gr.Pfizer.bootcamp3.team6.restapi.resource.impl.*;
import org.restlet.Application;
import org.restlet.routing.Router;

public class CustomRouter {
    // make a router that takes information from an application
    private Application application;

    public CustomRouter(Application application) {
        this.application = application;
    }

    public Router createApiRouter() {
        Router router = new Router(application.getContext());

        // the repetition is happening because of the trailing slash issue
        // Patient's endpoints

        router.attach("/patients", PatientListResourceImpl.class); // GET
        router.attach("/patients/", PatientListResourceImpl.class); // GET

        router.attach("/patients/{id}", PatientResourceImpl.class); // GET
        router.attach("/patients/{id}/", PatientResourceImpl.class); // GET

        // Doctor's endpoints
        router.attach("/doctors", DoctorListResourceImpl.class); // GET
        router.attach("/doctors/", DoctorListResourceImpl.class); // GET

        router.attach("/doctors/{id}", DoctorResourceImpl.class); // GET
        router.attach("/doctors/{id}/", DoctorResourceImpl.class); // GET
        //router.attach("/doctors/{id}/patients", DoctorPatientsResourceImpl.class);
        //router.attach("/doctors/{id}/patients/", DoctorPatientsResourceImpl.class);

        // Consultation's endpoints
        //router.attach("/patients/{id}/consultations/{id}", ConsultationResourceImpl.class); // GET
        //router.attach("/patients/{id}/consultations/{id}/", ConsultationResourceImpl.class); // GET

        router.attach("/patients/{id}/consultations", ConsultationListResourceImpl.class); // POST/GET
        router.attach("/patients/{id}/consultations/", ConsultationListResourceImpl.class); // POST/GET

        return router;
    }

    public Router publicResources() {
        Router router = new Router();
        router.attach("/ping", PingServerResource.class);
        return router;
    }
}