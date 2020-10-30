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
        // the order of the endpoints attached to the router matters, first are the ones without any path parameter and then the other ones that have a parameter.
        // Patient's endpoints
        router.attach("/patients", PatientListResourceImpl.class); // GET,POST
        router.attach("/patients/", PatientListResourceImpl.class); // GET,POST

        router.attach("/patients/need", PatientIneedListResourceImpl.class); // GET
        router.attach("/patients/need/", PatientIneedListResourceImpl.class); // GET

        router.attach("/patients/{id}", PatientResourceImpl.class); // GET/DELETE
        router.attach("/patients/{id}/", PatientResourceImpl.class); // GET/DELETE

        // Doctor's endpoints
        router.attach("/doctors", DoctorListResourceImpl.class); // GET,POST
        router.attach("/doctors/", DoctorListResourceImpl.class); // GET,POST

        router.attach("/doctors/{id}", DoctorResourceImpl.class); // GET,DELETE
        router.attach("/doctors/{id}/", DoctorResourceImpl.class); // GET,DELETE

        router.attach("/doctors/{id}/patients", DoctorPatientsListResourceImpl.class); //GET
        router.attach("/doctors/{id}/patients/", DoctorPatientsListResourceImpl.class); //GET

        // Consultation's endpoints
        router.attach("/consultations/{id}", ConsultationResourceImpl.class); // GET,PUT
        router.attach("/consultations/{id}/", ConsultationResourceImpl.class); // GET,PUT

        router.attach("/patients/{id}/consultations", ConsultationListResourceImpl.class); // POST/GET
        router.attach("/patients/{id}/consultations/", ConsultationListResourceImpl.class); // POST/GET

        // Measurement's endpoints
        router.attach("/patients/{id}/carbs", CarbListResourceImpl.class); // POST/GET
        router.attach("/patients/{id}/carbs/", CarbListResourceImpl.class); // POST/GET
        router.attach("/patients/{id}/glucose", GlucoseListResourceImpl.class); // POST/GET
        router.attach("/patients/{id}/glucose/",GlucoseListResourceImpl.class); // POST/GET

        router.attach("/carbs/{id}", CarbResourceImpl.class); //GET
        router.attach("/carbs/{id}/", CarbResourceImpl.class); //GET

        router.attach("/glucose/{id}", GlucoseResourceImpl.class); //GET
        router.attach("/glucose/{id}/", GlucoseResourceImpl.class); //GET

        return router;
    }

    public Router publicResources() {
        Router router = new Router();
        router.attach("/ping", PingServerResource.class);
        return router;
    }
}