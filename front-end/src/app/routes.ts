import { Routes } from '@angular/router';
import { AccountComponent } from './account/account/account.component';
import { DaConsultationComponent } from './da-consultation/da-consultation/da-consultation.component';
import { DaHomeComponent } from './da-home/da-home/da-home.component';
import { DaNewPatientComponent } from './da-new-patient/da-new-patient/da-new-patient.component';
import { DaOnePatientComponent } from './da-one-patient/da-one-patient/da-one-patient.component';
import { SignupDoctorFormComponent } from './forms/signup-doctor-form/signup-doctor-form.component';
import { LogInComponent } from './log-in/log-in/log-in.component';
import { MdrHomeComponent } from './mdr-home/mdr-home/mdr-home.component';
import { MdrViewDataComponent } from './mdr-view-data/mdr-view-data/mdr-view-data.component';
import { PatientSignUpModule } from './patient-sign-up/patient-sign-up.module';
import { PatientSignUpComponent } from './patient-sign-up/patient-sign-up/patient-sign-up.component';
import { ReDocReportModule } from './re-doc-report/re-doc-report.module';
import { ReDocReportComponent } from './re-doc-report/re-doc-report/re-doc-report.component';
import { ReHomeComponent } from './re-home/re-home/re-home.component';
import { RePatReportModule } from './re-pat-report/re-pat-report.module';
import { RePatReportComponent } from './re-pat-report/re-pat-report/re-pat-report.component';

export const routes: Routes =[
    {path: '', redirectTo: 'login', pathMatch: 'full'},
    {path: 'login', component: LogInComponent },
    {path: 'signup', component: PatientSignUpComponent},
    {path: 'medidatarepo', component: MdrHomeComponent},
    {path: 'medidatarepo/account', component: AccountComponent},
    {path: 'medidatarepo/viewdata', component: MdrViewDataComponent},
    {path: 'doctoradvice', component: DaHomeComponent},
    {path: 'doctoradvice/account', component: AccountComponent},
    {path: 'doctoradvice/patient/:id', component: DaOnePatientComponent},
    {path: 'doctoradvice/consultation/:id', component: DaConsultationComponent},
    {path: 'doctoradvice/newpatients', component: DaNewPatientComponent},
    {path: 'reporter', component: ReHomeComponent},
    {path: 'reporter/doctorsignup', component: SignupDoctorFormComponent},
    {path: 'reporter/doctorreport', component: ReDocReportComponent},
    {path: 'reporter/patientreport', component: RePatReportComponent}
];