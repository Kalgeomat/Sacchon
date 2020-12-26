# Class Diagram
![class diagram](classdiagram.jpg?raw=true)

# API Endpoints
### Patient

Get all patients:
HTTP GET => baseUrl + /patients (R Patient Report Page in the "Choose a patient" dropdown)

Get all new patients:
HTTP GET => baseUrl + /patients/new (DA new patient's page)

Get all patients in need:
HTTP GET => baseUrl + /patients/need (R Patient Report Page in the "Patients Waiting for Consultation"

Get a patient:
HTTP GET => baseUrl + /patients/id (MDR Homepage, DA one-patient page)

Get a patient's average glucose:
HTTP GET => baseUrl + /patients/id/glucose/start/end (MDR view data page)

Get a patient's average carb:
HTTP GET => baseUrl + /patients/id/carb/start/end (MDR view data page)

Post a patient:
HTTP POST => baseUrl + /patients (MDR sign up page)

Delete a patient (patient removes account):  
HTTP DELETE => baseUrl + /patients/id (MDR account page in "REMOVE ACCOUNT")

### Consultation

Get a patient's consultations:
HTTP GET => baseUrl + /patients/id/consultations (MDR past consultations page)

Get a patient's consultation:
HTTP GET => baseUrl + consultations/id (MDR homepage)

Post a consultation for a patient:
HTTP POST => baseUrl + /patients/id/consultations (DA consultation page)

Update a patient's consultation:
HTTP PUT => baseUrl + /consultations/id (we don't know yet)

### Measurement

Get a patient's measurements:
HTTP GET => baseUrl + /patients/id/carbs (MDR view data page, DA one-patient page)

Get a patient's measurements:
HTTP GET => baseUrl + /patients/id/glucose (MDR view data page, DA one-patient page)

Get a patient's measurement:
HTTP GET => baseUrl + /carbs/id (we don't know yet)

Get a patient's measurement:
HTTP GET => baseUrl +/glucose/id (we don't know yet)

Post a patient's measurement:
HTTP POST => baseUrl + /patients/id/carbs (MDR homepage)

Post a patient's measurement:
HTTP POST => baseUrl + /patients/id/glucose (MDR homepage)

Update a patient's measurement:
HTTP PUT => baseUrl + /carbs/id (MDR view data page)

Update a patient's measurement:
HTTP PUT => baseUrl + /glucoses/id (MDR view data page)

Delete a patient's measurement:
HTTP DELETE => baseUrl +/carbs/id (MDR view data page)

Delete a patient's measurement:
HTTP DELETE => baseUrl + glucose/id (MDR view data page)

### Doctor

Get all doctors:
HTTP GET => baseUrl + /doctors (R Doctor Report Page in the "Choose a doctor" dropdown)

Get a doctor:
HTTP GET => baseUrl + /doctors/id (DA homepage)

Get a doctor's patients:
HTTP GET => baseUrl + /doctors/id/patients (DA homepage in "ALL MY PATIENTS")

Get a doctor's patients in need:
HTTP GET => baseUrl + /doctors/id/patients/ineed (DA homepage in "MY PATIENTS IN NEED OF CONSULTING")

Get a doctor's patient:
HTTP GET => baseUrl + /patients/id (DA one-patient page)

Delete a doctor (doctor removes account):
HTTP DELETE => baseUrl + /doctors/id (DA account page in "REMOVE ACCOUNT")

### Reporter(Chief)

Get all inactive doctors:
HTTP GET => baseUrl + /doctors/noactive/start/end (R doctor report page in "DOCTORS WITH NO ACTIVITY")

Get all inactive patients:
HTTP GET => baseUrl + /patients/noactive/start/end (R patient report page in "PATIENTS WITH NO ACTIVITY")

Get a patient's activity data:
HTTP GET => baseUrl + /patients/id/activity/start/end (R patient report page in "PERSONAL MONITOR DATA")

Get a doctor's activity data:
HTTP GET => baseUrl + /doctors/id/activity/start/end (R doctor report page in "CONSULTATION SUBMISSIONS")

Post a doctor:
HTTP POST => baseUrl + /doctors (R doctor signup page)

### Authentication
Login a user:
HTTP POST => baseUrl + /patients/login (login page)

Sign up a patient:
HTTP POST => baseUrl + /patients/signup (sign up page)

Sign up a doctor (from chief's system):
HTTP POST => baseUrl + /doctors/signup (sign up page)

### Example Requests

1. POST sign up doctor http://localhost:9000/SacchonApp/doctors/signup

    #### JSON

    ```json
    {    
        "username":"smith",
        "firstName": "Smith",
        "lastName": "Jenty",
        "email": "smithj@freemail.com",
        "password": "smith",
        "telephoneNumber": 2310299999,
        "address": "Egnatia 6",
        "dob": "1995-01-01T00:00:00.00Z"
    }
    ```

    #### Result

    ```json
    {
        "id": 4,
        "username": "smith",
        "firstName": "Smith",
        "lastName": "Jenty",
        "email": "smithj@freemail.com",
        "password": null,
        "telephoneNumber": 2310299999,
        "address": "Egnatia 6",
        "dob": 788918400000,
        "gender": null,
        "uri": "http://localhost:9000/SacchonApp/doctor/4"
    }
    ```

1. POST sign up patient http://localhost:9000/SacchonApp/patients/signup

    #### JSON

    ```json
    {    
        "username":"Helen",
        "firstName": "Maria",
        "lastName": "Lana",
        "email": "maria@freemail.com",
        "password": "helen",
        "telephoneNumber": 2310299999,
        "address": "Egnatia 6",
        "dob": "1995-01-01T00:00:00.00Z"
    }
    ```

    #### Result

    ```json
    {
        "id": 2,
        "username": "Helen",
        "firstName": "Maria",
        "lastName": "Lana",
        "email": "maria@freemail.com",
        "password": null,
        "telephoneNumber": 2310299999,
        "address": "Egnatia 6",
        "dob": 788918400000,
        "gender": null,
        "uri": "http://localhost:9000/SacchonApp/patient/2"
    }
    ```

1. GET login doctor http://localhost:9000/SacchonApp/login

    #### Result

    ```json
    {
        "id": 4,
        "username": "smith",
        "firstName": "Smith",
        "lastName": "Jenty",
        "email": "smithj@freemail.com",
        "telephoneNumber": 2310299999,
        "address": "Egnatia 6",
        "dob": 788918400000,
        "gender": null,
        "role": "ROLE_DOCTOR"
    }
    ```

1. GET login patient http://localhost:9000/SacchonApp/login (authorization username and password of the patient)

    #### Result

    ```json
    {
        "id": 2,
        "username": "Helen",
        "firstName": "Maria",
        "lastName": "Lana",
        "email": "maria@freemail.com",
        "telephoneNumber": 2310299999,
        "address": "Egnatia 6",
        "dob": 788918400000,
        "gender": null,
        "role": "ROLE_PATIENT"
    }
    ```

1. GET all patients-->http://localhost:9000/SacchonApp/patients/

    #### Result

    ```json
    [
        {
            "id": 1,
            "username": "Maria",
            "firstName": "Maria",
            "lastName": "Lana",
            "email": "maria@freemail.com",
            "password": null,
            "telephoneNumber": 2310299999,
            "address": "Egnatia 6",
            "dob": 788918400000,
            "gender": null,
            "uri": "http://localhost:9000/SacchonApp/patient/1"
        },
        {
            "id": 2,
            "username": "Helen",
            "firstName": "Maria",
            "lastName": "Lana",
            "email": "maria@freemail.com",
            "password": null,
            "telephoneNumber": 2310299999,
            "address": "Egnatia 6",
            "dob": 788918400000,
            "gender": null,
            "uri": "http://localhost:9000/SacchonApp/patient/2"
        }
    ]
    ```

1. GET/DELETE one specific patient http://localhost:9000/SacchonApp/patients/1

    #### Result

    ```json
    {
        "id": 1,
        "username": "Maria",
        "firstName": "Maria",
        "lastName": "Lana",
        "email": "maria@freemail.com",
        "password": null,
        "telephoneNumber": 2310299999,
        "address": "Egnatia 6",
        "dob": 788918400000,
        "gender": null,
        "uri": "http://localhost:9000/SacchonApp/patient/1"
    }
    ```

1. GET doctors http://localhost:9000/SacchonApp/doctors/

    #### Result

    ```json
    [
        {
            "id": 4,
            "username": "smith",
            "firstName": "Smith",
            "lastName": "Jenty",
            "email": "smithj@freemail.com",
            "password": null,
            "telephoneNumber": 2310299999,
            "address": "Egnatia 6",
            "dob": 788918400000,
            "gender": null,
            "uri": "http://localhost:9000/SacchonApp/doctor/4"
        }
    ]
    ```

1.  GET/DELETE a specific doctor   http://localhost:9000/SacchonApp/doctors/4

    **Result**

    ```json
    {
        "id": 4,
        "username": "smith",
        "firstName": "Smith",
        "lastName": "Jenty",
        "email": "smithj@freemail.com",
        "password": null,
        "telephoneNumber": 2310299999,
        "address": "Egnatia 6",
        "dob": 788918400000,
        "gender": null,
        "uri": "http://localhost:9000/SacchonApp/doctor/4"
    }
    ```

1. POST/GET one consultation to a patient http://localhost:9000/SacchonApp/patients/1/consultations

    #### JSON

    ```json
    {
        "description": "take xanax",
        "doctorId": 4
    }
    ```

    #### Result

    ```json
    {
        "id": 1,
        "description": "take xanax",
        "dateCreated": 1601909280000,
        "doctorId": 4,
        "doctorName": "Smith Jenty",
        "patientId": 1,
        "uri": "http://localhost:9000/SacchonApp/consultations/1"
    }
    ```

1. GET all doctor's patients http://localhost:9000/SacchonApp/doctors/4/patients

    #### Result

    ```jason
    [
        {
            "id": 1,
            "username": "Maria",
            "firstName": "Maria",
            "lastName": "Lana",
            "email": "maria@freemail.com",
            "password": null,
            "telephoneNumber": 2310299999,
            "address": "Egnatia 6",
            "dob": 788918400000,
            "gender": null,
            "uri": "http://localhost:9000/SacchonApp/patient/1"
        }
    ]
    ```

1. Get all patient's consultations  http://localhost:9000/SacchonApp/patients/1/consultations/

    #### Result

    ```json
    [
        {
            "id": 1,
            "description": "take xanax",
            "dateCreated": 1601909280000,
            "doctorId": 4,
            "doctorName": "Smith Jenty",
            "patientId": 1,
            "uri": "http://localhost:9000/SacchonApp/consultations/1"
        }
    ]
    ```

1. PUT/GET(to see the consultation) a consultation (only doctor can do this)  http://localhost:9000/SacchonApp/consultations/1/

    #### JSON

    ```json
    {
        "description": "dont eat carbs",
        "doctorId": 4
    }
    ```

    #### Result

    ```json
    {
        "id": 1,
        "description": "dont eat carbs",
        "dateCreated": 1601909280000,
        "doctorId": 4,
        "doctorName": "Smith Jenty",
        "patientId": 1,
        "uri": "http://localhost:9000/SacchonApp/consultations/1"
    }
    ```

1. POST/GET carb measurements http://localhost:9000/SacchonApp/patients/1/carbs

    #### JSON

    ```json
    {
          "carbInTake": 23,
          "dateMeasured": "2020-10-05T14:48:00.000Z"
    }
    ```

    #### Result

    ```json
    {
        "id": 1,
        "carbInTake": 23.0,
        "dateMeasured": 1601909280000,
        "patientId": 1,
        "uri": "http://localhost:9000/SacchonApp/carbs/1"
    }
    ```

1.  GET/PUT/DELETE carb measurements  http://localhost:9000/SacchonApp/carbs/1

    #### JSON

    ```json
    {
          "carbInTake": 75,
          "dateMeasured": "2020-10-07T18:48:00.000Z"
    }
    ```

    #### Result

    ```json
    {
        "id": 1,
        "carbInTake": 75.0,
        "dateMeasured": 1602096480000,
        "patientId": 1,
        "uri": "http://localhost:9000/SacchonApp/carbs/1"
    }
    ```

1. POST/GET glucose measurements http://localhost:9000/SacchonApp/patients/1/glucose

    #### JSON

    ```json
    {
        "bloodGlucoseLevel": 5.3,
        "dateMeasured": "2020-10-07T18:48:00.000Z"
    }
    ```

    #### Result

    ```json
    {
        "id": 1,
        "bloodGlucoseLevel": 5.3,
        "dateMeasured": 1602096480000,
        "patientId": 1,
        "uri": "http://localhost:9000/SacchonApp/glucose/1"
    }
    ```

1. GET/PUT/DELETE glucose measurements(a patient)  http://localhost:9000/SacchonApp/glucose/1

    #### JSON

    ```json
    {
        "bloodGlucoseLevel": 10,
        "dateMeasured": "2020-10-07T18:48:00.000Z"
    }
    ```

    #### Result

    ```json
    {
        "id": 1,
        "bloodGlucoseLevel": 10.0,
        "dateMeasured": 1602096480000,
        "patientId": 1,
        "uri": "http://localhost:9000/SacchonApp/glucose/1"
    }
    ```

1. GET patient's average of glucose http://localhost:9000/SacchonApp/patients/1/glucose/1601931600000/1602190800000

    *Database: First day 8.3 and 6.3, Second day 4.3 , 7.3 , 5.3  Dates(2020-10-7 , 2020-10-8)*

    #### Result

    ```json
    {
        "patientId": 1,
        "startDate": 1602006265000,
        "endDate": 1602265465000,
        "glucoseStatistics": 6.466666666666667,
        "uri": "http://localhost:9000/SacchonApp/patients/1"
    }
    ```

1. GET patient's average of carb http://localhost:9000/SacchonApp/patients/1/carbs/1578163465000/1578509065000

    *Database values: Date1(2020-1-5) carbInTake=23 , Date2(2020-1-6) carbInTake=10, Date3(2020-1-7) carbInTake=50*

    #### Result

    ```json
    {
        "patientId": 1,
        "startDate": 1578163465000,
        "endDate": 1578509065000,
        "carbsStatistics": 27.666666666666668,
        "uri": "http://localhost:9000/SacchonApp/patients/1"
    }
    ```

1. GET The list of the patients with no activity over a time range http://localhost:9000/SacchonApp/patients/inactive/1603219068/1604086668

    *Dates from(2020-10-20) to (2020-10-30)*

    #### Result

    ```json
    [
        {
            "id": 1,
            "username": "Maria",
            "firstName": "Maria",
            "lastName": "Lana",
            "email": "maria@freemail.com",
            "password": null,
            "telephoneNumber": 2310299999,
            "address": "Egnatia 6",
            "dob": 788918400000,
            "gender": null,
            "uri": "http://localhost:9000/SacchonApp/patient/1"
        },
        {
            "id": 2,
            "username": "Helen",
            "firstName": "Maria",
            "lastName": "Lana",
            "email": "maria@freemail.com",
            "password": null,
            "telephoneNumber": 2310299999,
            "address": "Egnatia 6",
            "dob": 788918400000,
            "gender": null,
            "uri": "http://localhost:9000/SacchonApp/patient/2"
        },
        {
            "id": 5,
            "username": "kelly",
            "firstName": "Kelly",
            "lastName": "g",
            "email": "kk@",
            "password": null,
            "telephoneNumber": 8,
            "address": "k",
            "dob": 949442400000,
            "gender": null,
            "uri": "http://localhost:9000/SacchonApp/patient/5"
        }
    ]
    ```

1. GET The list of the doctors with no activity over a time range http://localhost:9000/SacchonApp/patients/inactive/1603219068/1604086668

    *Dates from(2020-10-20) to (2020-10-30)*

    #### Result

    ```jason
    [
        {
            "id": 5,
            "username": "kil",
            "firstName": "h",
            "lastName": "c",
            "email": null,
            "password": null,
            "telephoneNumber": 5,
            "address": "d",
            "dob": null,
            "gender": null,
            "ifNeedsConsultation": false,
            "uri": "http://localhost:9000/SacchonApp/patient/5"
        },
        {
            "id": 6,
            "username": "john",
            "firstName": "john",
            "lastName": "kk",
            "email": "hh@",
            "password": null,
            "telephoneNumber": 2,
            "address": "55",
            "dob": 981064800000,
            "gender": "FEMALE",
            "ifNeedsConsultation": true,
            "uri": "http://localhost:9000/SacchonApp/patient/6"
        }
    ]
    ```

1. GET The list of the patients who are waiting for a consultation and the time
elapsed since they needed to have one http://localhost:9000/SacchonApp/patients/need

    #### Result

    ```json
    [
        {
            "id": 6,
            "username": "john",
            "firstName": "john",
            "lastName": "kk",
            "email": "hh@",
            "password": null,
            "telephoneNumber": 2,
            "address": "55",
            "dob": 981064800000,
            "gender": "FEMALE",
            "uri": "http://localhost:9000/SacchonApp/patient/6",
            "nubmerOfDaysIneed": 3
        }
    ]
    ```
