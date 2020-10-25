# Sacchon

#Patient
Get all patients:
HTTP GET => baseUrl + /patients (R Patient Report Page in the "Choose a patient" dropdown) 

Get all new patients:
HTTP GET => baseUrl + /patients/new (DA new patient's page)

Get all patients in need:
HTTP GET => baseUrl + /patients/ineed (R Patient Report Page in the "Patients Waiting for Consultation"

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

#Consultation

Get a patient's consultations:
HTTP GET => baseUrl + /patients/id/consultations (MDR past consultations page)

Get a patient's consultation:
HTTP GET => baseUrl + /patients/id/consultations/id (MDR homepage)

Post a consultation for a patient:
HTTP POST => baseUrl + /patients/id/consultations (DA consultation page)

Update a patient's consultation:
HTTP PUT => baseUrl + /patients/id/consultations/id (we don't know yet)

#Measurement

Get a patient's measurements:
HTTP GET => baseUrl + /patients/id/measurements (MDR view data page, DA one-patient page)

Get a patient's measurement:
HTTP GET => baseUrl + /patients/id/measurements/id (we don't know yet)

Post a patient's measurement:
HTTP POST => baseUrl + /patients/id/measurements (MDR homepage)

Update a patient's measurement:
HTTP PUT => baseUrl + /patients/id/measurements/id (MDR view data page)

Delete a patient's measurement:
HTTP DELETE => baseUrl + /patients/id/measurements/id (MDR view data page)

#Doctor

Get all doctors:
HTTP GET => baseUrl + /doctors (R Doctor Report Page in the "Choose a doctor" dropdown)

Get a doctor:
HTTP GET => baseUrl + /doctors/id (DA homepage)

Get a doctor's patients:
HTTP GET => baseUrl + /doctors/id/patients (DA homepage in "ALL MY PATIENTS")

Get a doctor's patients in need:
HTTP GET => baseUrl + /doctors/id/patients/ineed (DA homepage in "MY PATIENTS IN NEED OF CONSULTING")

Get a doctor's patient:
HTTP GET => baseUrl + /doctors/id/patients/id (DA one-patient page)

Delete a doctor (doctor removes account):
HTTP DELETE => baseUrl + /doctors/id (DA account page in "REMOVE ACCOUNT")

#Reporter(Chief)

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

#Authentication

Sign up a patient:
HTTP POST => baseUrl + /patients/signup (sign up page)

Login a patient:
HTTP POST => baseUrl + /patients/login (login page)

Sign up a doctor (from chief's system):
HTTP POST => baseUrl + /doctors/signup (sign up page)

Login a doctor:
HTTP POST => baseUrl + /doctors/login (login page)

Login the chief:
HTTP POST => baseUrl + /reporter/login (login page)

#Important Things to Notice
1. The indicated pages for each endpoint may not be the only ones. Meaning, there may be other pages as well that may use that endpoint.
2. There are some endpoints that we still don’t know where we can use them. 

