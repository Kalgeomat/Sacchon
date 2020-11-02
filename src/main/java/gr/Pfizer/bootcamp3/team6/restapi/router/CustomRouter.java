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
        // Authentication endpoint
        // This login endpoint is for all three roles
        router.attach("/login", LoginResourceImpl.class); //POST
        router.attach("/login/", LoginResourceImpl.class); //POST

        // sign up for a doctor
        router.attach("/doctors/signup", DoctorSignUpResourceImpl.class); // POST
        router.attach("/doctors/signup/", DoctorSignUpResourceImpl.class); // POST

        // Patient's endpoints
        router.attach("/patients", PatientListResourceImpl.class); // GET
        router.attach("/patients/", PatientListResourceImpl.class); // GET

        router.attach("/patients/need", PatientIneedListResourceImpl.class); // GET
        router.attach("/patients/need/", PatientIneedListResourceImpl.class); // GET

        router.attach("/patients/new", PatientNewListResourceImpl.class); // GET
        router.attach("/patients/new/", PatientNewListResourceImpl.class); // GET

        router.attach("/patients/{id}", PatientResourceImpl.class); // GET/DELETE
        router.attach("/patients/{id}/", PatientResourceImpl.class); // GET/DELETE

        // Doctor's endpoints
        router.attach("/doctors", DoctorListResourceImpl.class); // GET
        router.attach("/doctors/", DoctorListResourceImpl.class); // GET

        router.attach("/doctors/{id}", DoctorResourceImpl.class); // GET,DELETE
        router.attach("/doctors/{id}/", DoctorResourceImpl.class); // GET,DELETE

        router.attach("/doctors/{id}/patients", DoctorPatientsListResourceImpl.class); //GET
        router.attach("/doctors/{id}/patients/", DoctorPatientsListResourceImpl.class); //GET

        router.attach("/doctors/{id}/patients/need", DoctorPatientNeedResourceImpl.class); //GET
        router.attach("/doctors/{id}/patients/need/", DoctorPatientNeedResourceImpl.class); //GET

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

        router.attach("/carbs/{id}", CarbResourceImpl.class); //GET,PUT,DELETE
        router.attach("/carbs/{id}/", CarbResourceImpl.class); //GET,PUT,DELETE

        router.attach("/glucose/{id}", GlucoseResourceImpl.class); //GET,PUT,DELETE
        router.attach("/glucose/{id}/", GlucoseResourceImpl.class); //GET,PUT,DELETE

        router.attach("/patients/{id}/glucose/{startDate}/{endDate}", GlucoseStatisticsResourceImpl.class); // GET
        router.attach("/patients/{id}/glucose/{startDate}/{endDate}/",GlucoseStatisticsResourceImpl.class); // GET

        router.attach("/patients/{id}/carbs/{startDate}/{endDate}", CarbsStatisticsResourceImpl.class); // GET
        router.attach("/patients/{id}/carbs/{startDate}/{endDate}/", CarbsStatisticsResourceImpl.class); // GET



        return router;
    }

    public Router publicResources() {
        Router router = new Router();
        // test router
        router.attach("/ping", PingServerResource.class);

        // sign up for a patient
        router.attach("/patients/signup", PatientSignUpResourceImpl.class); // POST
        router.attach("/patients/signup/", PatientSignUpResourceImpl.class); // POST

        return router;
    }
}