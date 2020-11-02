# Sacchon

*Patient*

Get all patients:
HTTP GET => baseUrl + /patients (R Patient Report Page in the "Choose a patient" dropdown) *DONE*

Get all new patients:
HTTP GET => baseUrl + /patients/new (DA new patient's page) *DONE*

Get all patients in need:
HTTP GET => baseUrl + /patients/need (R Patient Report Page in the "Patients Waiting for Consultation" *DONE*

Get a patient:
HTTP GET => baseUrl + /patients/id (MDR Homepage, DA one-patient page) *DONE*

Get a patient's average glucose:
HTTP GET => baseUrl + /patients/id/glucose/start/end (MDR view data page) *DONE*

Get a patient's average carb:
HTTP GET => baseUrl + /patients/id/carb/start/end (MDR view data page) *DONE*

Post a patient:
HTTP POST => baseUrl + /patients (MDR sign up page) *DONE*

Delete a patient (patient removes account):  
HTTP DELETE => baseUrl + /patients/id (MDR account page in "REMOVE ACCOUNT")  *DONE*

*Consultation*

Get a patient's consultations:
HTTP GET => baseUrl + /patients/id/consultations (MDR past consultations page) *DONE*

Get a patient's consultation:
HTTP GET => baseUrl + consultations/id (MDR homepage) *DONE*

Post a consultation for a patient:
HTTP POST => baseUrl + /patients/id/consultations (DA consultation page) *DONE*

Update a patient's consultation:
HTTP PUT => baseUrl + /consultations/id (we don't know yet) *DONE*

*Measurement*

Get a patient's measurements:
HTTP GET => baseUrl + /patients/id/carbs (MDR view data page, DA one-patient page) *DONE*

Get a patient's measurements:
HTTP GET => baseUrl + /patients/id/glucose (MDR view data page, DA one-patient page) *DONE*

Get a patient's measurement:
HTTP GET => baseUrl + /carbs/id (we don't know yet) *DONE*

Get a patient's measurement:
HTTP GET => baseUrl +/glucose/id (we don't know yet) *DONE*

Post a patient's measurement:
HTTP POST => baseUrl + /patients/id/carbs (MDR homepage) *DONE*

Post a patient's measurement:
HTTP POST => baseUrl + /patients/id/glucose (MDR homepage) *DONE*

Update a patient's measurement:
HTTP PUT => baseUrl + /carbs/id (MDR view data page) *DONE*

Update a patient's measurement:
HTTP PUT => baseUrl + /glucoses/id (MDR view data page) *DONE*

Delete a patient's measurement:
HTTP DELETE => baseUrl +/carbs/id (MDR view data page) *DONE*

Delete a patient's measurement:
HTTP DELETE => baseUrl + glucose/id (MDR view data page) *DONE*

*Doctor*

Get all doctors:
HTTP GET => baseUrl + /doctors (R Doctor Report Page in the "Choose a doctor" dropdown) *DONE*

Get a doctor:
HTTP GET => baseUrl + /doctors/id (DA homepage) *DONE*

Get a doctor's patients:
HTTP GET => baseUrl + /doctors/id/patients (DA homepage in "ALL MY PATIENTS") *DONE*

Get a doctor's patients in need:
HTTP GET => baseUrl + /doctors/id/patients/ineed (DA homepage in "MY PATIENTS IN NEED OF CONSULTING") *DONE*

Get a doctor's patient:
HTTP GET => baseUrl + /patients/id (DA one-patient page) *DONE* 

Delete a doctor (doctor removes account):
HTTP DELETE => baseUrl + /doctors/id (DA account page in "REMOVE ACCOUNT") *DONE*

*Reporter(Chief)*

Get all inactive doctors:
HTTP GET => baseUrl + /doctors/noactive/start/end (R doctor report page in "DOCTORS WITH NO ACTIVITY")

Get all inactive patients:
HTTP GET => baseUrl + /patients/noactive/start/end (R patient report page in "PATIENTS WITH NO ACTIVITY")

Get a patient's activity data:
HTTP GET => baseUrl + /patients/id/activity/start/end (R patient report page in "PERSONAL MONITOR DATA")

Get a doctor's activity data:
HTTP GET => baseUrl + /doctors/id/activity/start/end (R doctor report page in "CONSULTATION SUBMISSIONS")

Post a doctor:
HTTP POST => baseUrl + /doctors (R doctor signup page) *DONE*

*Authentication*

Sign up a patient:
HTTP POST => baseUrl + /patients/signup (sign up page) *DONE*

Login a patient:
HTTP POST => baseUrl + /patients/login (login page) *DONE*

Sign up a doctor (from chief's system):
HTTP POST => baseUrl + /doctors/signup (sign up page) *DONE*

Login a doctor:
HTTP POST => baseUrl + /doctors/login (login page) *DONE*

Login the chief:
HTTP POST => baseUrl + /reporter/login (login page) *DONE*

*JSON*

*1. POST* a patient-->http://localhost:9000/SacchonApp/patients/     
{ 
    "firstName": "Helen",
    "lastName": "Chatzi",
    "email": "helen@freemail.com",
    "password": "2222",
    "telephoneNumber": 2310299999,
    "address": "Tsimiski 6",
    "dob": "1995-01-01T00:00:00.00Z",
    "gender":1
}
*Result*
{
    "id": 1,
    "firstName": "Helen",
    "lastName": "Chatzi",
    "email": "helen@freemail.com",
    "password": "2222",
    "telephoneNumber": 2310299999,
    "address": "Tsimiski 6",
    "dob": 788918400000,
    "gender": "FEMALE",
    "uri": "http://localhost:9000/SacchonApp/patient/1"
}
*2. GET* all patients-->http://localhost:9000/SacchonApp/patients/

*Result*

[
    {
        "id": 1,
        "firstName": "Helen",
        "lastName": "Chatzi",
        "email": "helen@freemail.com",
        "password": "2222",
        "telephoneNumber": 2310299999,
        "address": "Tsimiski 6",
        "dob": 788918400000,
        "gender": "FEMALE",
        "uri": "http://localhost:9000/SacchonApp/patient/1"
    },
    {
        "id": 2,
        "firstName": "Evita",
        "lastName": "Papadopoulou",
        "email": "evita@freemail.com",
        "password": "2222",
        "telephoneNumber": 2310299999,
        "address": "Tsimiski 6",
        "dob": 788918400000,
        "gender": "FEMALE",
        "uri": "http://localhost:9000/SacchonApp/patient/2"
    }
]
*3. GET* a patient --> http://localhost:9000/SacchonApp/patients/1
*Result*
{
    "id": 1,
    "firstName": "Helen",
    "lastName": "Chatzi",
    "email": "helen@freemail.com",
    "password": "2222",
    "telephoneNumber": 2310299999,
    "address": "Tsimiski 6",
    "dob": 788918400000,
    "gender": "FEMALE",
    "uri": "http://localhost:9000/SacchonApp/patient/1"
}

*4. POST* post a doctor--> http://localhost:9000/SacchonApp/doctors/   

{ 
    "firstName": "Maria",
    "lastName": "Smith",
    "email": "maria@freemail.com",
    "password": "2222",
    "telephoneNumber": 2310299999,
    "address": "Tsimiski 6",
    "dob": "1995-01-01T00:00:00.00Z",
    "gender":1
     
}
*Result*
{
    "id": 1,
    "firstName": "Maria",
    "lastName": "Smith",
    "email": "maria@freemail.com",
    "password": "2222",
    "telephoneNumber": 2310299999,
    "address": "Tsimiski 6",
    "dob": 788918400000,
    "gender": "FEMALE",
    "uri": "http://localhost:9000/SacchonApp/doctor/1"
}
*5. GET* doctors http://localhost:9000/SacchonApp/doctors/
*Result*

[
    {
        "id": 1,
        "firstName": "Maria",
        "lastName": "Smith",
        "email": "maria@freemail.com",
        "password": "2222",
        "telephoneNumber": 2310299999,
        "address": "Tsimiski 6",
        "dob": 788918400000,
        "gender": "FEMALE",
        "uri": "http://localhost:9000/SacchonApp/doctor/1"
    },
    {
        "id": 2,
        "firstName": "Dina",
        "lastName": "Star",
        "email": "dinaS@freemail.com",
        "password": "2222",
        "telephoneNumber": 2310299999,
        "address": "Tsimiski 6",
        "dob": 788918400000,
        "gender": "FEMALE",
        "uri": "http://localhost:9000/SacchonApp/doctor/2"
    }
]
*6. GET* a specific doctor-->http://localhost:9000/SacchonApp/doctors/1
*Result*
{
    "id": 1,
    "firstName": "Maria",
    "lastName": "Smith",
    "email": "maria@freemail.com",
    "password": "2222",
    "telephoneNumber": 2310299999,
    "address": "Tsimiski 6",
    "dob": 788918400000,
    "gender": "FEMALE",
    "uri": "http://localhost:9000/SacchonApp/doctor/1"
}
*7. GET* when you want to see doctor's patients---> http://localhost:9000/SacchonApp/doctors/1/patients

*Result*
[
    {
        "id": 1,
        "firstName": "Helen",
        "lastName": "Chatzi",
        "email": "helen@freemail.com",
        "password": "2222",
        "telephoneNumber": 2310299999,
        "address": "Tsimiski 6",
        "dob": 788918400000,
        "gender": "FEMALE",
        "uri": "http://localhost:9000/SacchonApp/patient/1"
    },
    {
        "id": 2,
        "firstName": "Evita",
        "lastName": "Papadopoulou",
        "email": "evita@freemail.com",
        "password": "2222",
        "telephoneNumber": 2310299999,
        "address": "Tsimiski 6",
        "dob": 788918400000,
        "gender": "FEMALE",
        "uri": "http://localhost:9000/SacchonApp/patient/2"
    }
]
*8. POST* a consultation to a patient http://localhost:9000/SacchonApp/patients/1/consultations/
{
    "description": "take xanax",
    "dateCreated": "2020-10-05T14:48:00.000Z",
    "doctorId": 1
}
*Result*
{
    "id": 1,
    "description": "take xanax",
    "dateCreated": 1601909280000,
    "doctorId": 1,
    "doctorName": "Maria Smith",
    "patientId": 1,
    "uri": "http://localhost:9000/SacchonApp/consultations/1"
}
*9. GET* consultations of a patient http://localhost:9000/SacchonApp/patients/1/consultations/
*Result*
[
    {
        "id": 1,
        "description": "take zanax",
        "dateCreated": 1601909280000,
        "doctorId": 1,
        "doctorName": "Maria Smith",
        "patientId": 1,
        "uri": "http://localhost:9000/SacchonApp/consultations/1"
    }
]
*10. POST* patient post carb measurements http://localhost:9000/SacchonApp/patients/1/carbs
{
      "carbInTake": 23,
      "dateMeasured": "2020-10-05T14:48:00.000Z"
}
*Result*
{
    "id": 1,
    "carbInTake": 23.0,
    "dateMeasured": 1601909280000,
    "patientId": 1,
    "uri": "http://localhost:9000/SacchonApp/carbs/1"
}
*11.* when a patient *GET/PUT/DELETE* carb measurements  http://localhost:9000/SacchonApp/carbs/1
{
      "carbInTake": 75,
      "dateMeasured": "2020-10-07T18:48:00.000Z"
}
*Result*
{
    "id": 1,
    "carbInTake": 75.0,
    "dateMeasured": 1602096480000,
    "patientId": 1,
    "uri": "http://localhost:9000/SacchonApp/carbs/1"
}
*12.*  when a patient *POST/GET* glucose measurements http://localhost:9000/SacchonApp/patients/1/glucose
{
    "bloodGlucoseLevel": 5.3,
    "dateMeasured": "2020-10-07T18:48:00.000Z"
}
*Result*
{
    "id": 1,
    "bloodGlucoseLevel": 5.3,
    "dateMeasured": 1602096480000,
    "patientId": 1,
    "uri": "http://localhost:9000/SacchonApp/glucose/1"
}	

*13. GET* patients tha need consultations http://localhost:9000/SacchonApp/patients/need
*Result*
[
    {
        "id": 5,
        "firstName": "Jason",
        "lastName": "Jey",
        "email": "jason@freemail.com",
        "password": "77",
        "telephoneNumber": 23456,
        "address": "mitropolews",
        "dob": 1020632400000,
        "gender": "MALE",
        "uri": "http://localhost:9000/SacchonApp/patient/5"
    }
]
*14.*  when a patient *GET/PUT/DELETE* glucose measurements http://localhost:9000/SacchonApp/glucose/1
{
    "bloodGlucoseLevel": 10,
    "dateMeasured": "2020-10-07T18:48:00.000Z"
}
*Result*
{
    "id": 1,
    "bloodGlucoseLevel": 10.0,
    "dateMeasured": 1602096480000,
    "patientId": 1,
    "uri": "http://localhost:9000/SacchonApp/glucose/1"
}
*15. GET*  patients of each doctor tha need consultations http://localhost:9000/SacchonApp/doctors/1/patients/need

*Result*
[
    {
        "id": 5,
        "firstName": "Jason",
        "lastName": "Jey",
        "email": "jason@freemail.com",
        "password": "77",
        "telephoneNumber": 23456,
        "address": "mitropolews",
        "dob": 1020632400000,
        "gender": "MALE",
        "uri": "http://localhost:9000/SacchonApp/patient/5"
    }
]


*Statistics*


*16. GET*  patient's average of glucose-->http://localhost:9000/SacchonApp/patients/1/glucose/1601931600000/1602190800000

Database values: First day  8.3 and 6.3 and the Second day 4.3 , 7.3 , 5.3  date(2020-10-7 , 2020-10-8)

*Result*

{
    "patientId": 1,
    "startDate": 1601931600000,
    "endDate": 1602190800000,
    "glucoseStatistics": 6.466666666666667,
    "uri": "http://localhost:9000/SacchonApp/patients/1"
}

*17. GET*  patient's average of carb-->http://localhost:9000/SacchonApp/patients/1/carbs/1601758800000/1602104400000

Database  values: Date(2020-1-5) carbInTake=23 , Date(2020-1-6) carbInTake=10, Date(2020-1-7) carbInTake=50

*Result*
{
    "patientId": 1,
    "startDate": 1601758800000,
    "endDate": 1602104400000,
    "carbsStatistics": 27.666666666666668,
    "uri": "http://localhost:9000/SacchonApp/patients/1"
}




