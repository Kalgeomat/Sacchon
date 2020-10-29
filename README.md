# Sacchon

**Patient**

_Get all patients:_
HTTP GET => baseUrl + /patients (R Patient Report Page in the "Choose a patient" dropdown) **DONE**

_Get all new patients:_
HTTP GET => baseUrl + /patients/new (DA new patient's page)

_Get all patients in need:_
HTTP GET => baseUrl + /patients/ineed (R Patient Report Page in the "Patients Waiting for Consultation"

_Get a patient:_
HTTP GET => baseUrl + /patients/id (MDR Homepage, DA one-patient page) **DONE**

_Get a patient's average glucose:_
HTTP GET => baseUrl + /patients/id/glucose/start/end (MDR view data page)

_Get a patient's average carb:_
HTTP GET => baseUrl + /patients/id/carb/start/end (MDR view data page)

_Post a patient:_
HTTP POST => baseUrl + /patients (MDR sign up page) **DONE**

_Delete a patient (patient removes account):_
HTTP DELETE => baseUrl + /patients/id (MDR account page in "REMOVE ACCOUNT")

**Consultation**

_Get a patient's consultations:_
HTTP GET => baseUrl + /patients/id/consultations (MDR past consultations page) **DONE**

_Get a patient's consultation:_
HTTP GET => baseUrl + /patients/id/consultations/id (MDR homepage)

_Post a consultation for a patient:_
HTTP POST => baseUrl + /patients/id/consultations (DA consultation page) **DONE**

_Update a patient's consultation:_
HTTP PUT => baseUrl + /patients/id/consultations/id (we don't know yet)

**Measurement**

_Get a patient's measurements:_
HTTP GET => baseUrl + /patients/id/carbs (MDR view data page, DA one-patient page) **DONE**

_Get a patient's measurements:_
HTTP GET => baseUrl + /patients/id/glucose (MDR view data page, DA one-patient page) **DONE**

_Get a patient's measurement:_
HTTP GET => baseUrl + /patients/id/carbs/id (we don't know yet)

_Get a patient's measurement:_
HTTP GET => baseUrl + /patients/id/glucose/id (we don't know yet)

_Post a patient's measurement:_
HTTP POST => baseUrl + /patients/id/carbs (MDR homepage) **DONE**

_Post a patient's measurement:_
HTTP POST => baseUrl + /patients/id/glucose (MDR homepage) **DONE**

_Update a patient's measurement:_
HTTP PUT => baseUrl + /patients/id/carbs/id (MDR view data page)

_Update a patient's measurement:_
HTTP PUT => baseUrl + /patients/id/glucoses/id (MDR view data page)

_Delete a patient's measurement:_
HTTP DELETE => baseUrl + /patients/id/carbs/id (MDR view data page)

_Delete a patient's measurement:_
HTTP DELETE => baseUrl + /patients/id/glucose/id (MDR view data page)

**Doctor**

_Get all doctors:_
HTTP GET => baseUrl + /doctors (R Doctor Report Page in the "Choose a doctor" dropdown) **DONE**

_Get a doctor:_
HTTP GET => baseUrl + /doctors/id (DA homepage) **DONE**

_Get a doctor's patients:_
HTTP GET => baseUrl + /doctors/id/patients (DA homepage in "ALL MY PATIENTS")

_Get a doctor's patients in need:_
HTTP GET => baseUrl + /doctors/id/patients/ineed (DA homepage in "MY PATIENTS IN NEED OF CONSULTING")

_Get a doctor's patient:_
HTTP GET => baseUrl + /doctors/id/patients/id (DA one-patient page)

_Delete a doctor (doctor removes account):_
HTTP DELETE => baseUrl + /doctors/id (DA account page in "REMOVE ACCOUNT")

**Reporter(Chief)**

_Get all inactive doctors:_
HTTP GET => baseUrl + /doctors/noactive/start/end (R doctor report page in "DOCTORS WITH NO ACTIVITY")

_Get all inactive patients:_
HTTP GET => baseUrl + /patients/noactive/start/end (R patient report page in "PATIENTS WITH NO ACTIVITY")

_Get a patient's activity data:_
HTTP GET => baseUrl + /patients/id/activity/start/end (R patient report page in "PERSONAL MONITOR DATA")

_Get a doctor's activity data:_
HTTP GET => baseUrl + /doctors/id/activity/start/end (R doctor report page in "CONSULTATION SUBMISSIONS")

_Post a doctor:_
HTTP POST => baseUrl + /doctors (R doctor signup page) **DONE**

**Authentication**

_Sign up a patient:_
HTTP POST => baseUrl + /patients/signup (sign up page)

_Login a patient:_
HTTP POST => baseUrl + /patients/login (login page)

_Sign up a doctor (from chief's system):_
HTTP POST => baseUrl + /doctors/signup (sign up page)

_Login a doctor:_
HTTP POST => baseUrl + /doctors/login (login page)

_Login the chief:_
HTTP POST => baseUrl + /reporter/login (login page)

**Important Things to Notice**
1. The indicated pages for each endpoint may not be the only ones. Meaning, there may be other pages as well that may use that endpoint.
2. There are some endpoints that we still don’t know where we can use them.



