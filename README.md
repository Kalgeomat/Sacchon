# Sacchon
This project is a diabetes management web application, which is used both from the patients and doctors of the respective field of expertize. More specifically, 
a patient can submit his medical data, related to diabetes, to the system at any time. After a month of data recording has elapsed, a doctor can review this data and provide
advice to the patient for the next month. This process is repeated until the patient or the doctor unregisters from the system. Additionally, there is also the Chief Doctor, 
an officer who can view reports which monitor the activity of patients and doctors in the system. So overall, this web application is essentially a diabetes monitoring system 
used both by patients and doctors.

Sacchon is divided into two distinct subsystems, the Sacchon Rest-API which is the back-end of the system and the Sacchon Angular App, which is the frontend. From the user's 
point of view though, the web app consists of three major components: 
* the Repository of Medical Data (MediDataRepo)
* the Doctor Advice Services System (DoctorAdvice)
* the Reporting Services (Reporter)

To elaborate, MediDataRepo keeps track of the users’ blood glucose level, daily consumed carbohydrates, and medication intake. In the DoctorAdvice section a team of doctors 
provide advice to patients on a per-call basis. Reporter provides a series of aggregation operations for creating tables and charts.
