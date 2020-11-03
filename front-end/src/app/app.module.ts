import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { FormsModule } from './forms/forms.module';
import { DaConsultationModule } from './da-consultation/da-consultation.module';
import { DaHomeModule } from './da-home/da-home.module';
import { DaNewPatientModule } from './da-new-patient/da-new-patient.module';
import { DaOnePatientModule } from './da-one-patient/da-one-patient.module';
import { DaHomeComponent } from './da-home/da-home/da-home.component';
import { ReDocReportModule } from './re-doc-report/re-doc-report.module';
import { ReHomeModule } from './re-home/re-home.module';
import { RePatReportModule } from './re-pat-report/re-pat-report.module';
import { AccountModule } from './account/account.module';
import { MdrHomeModule } from './mdr-home/mdr-home.module';
import { MdrViewDataModule } from './mdr-view-data/mdr-view-data.module';
import { LogInModule } from './log-in/log-in.module';
import { PatientSignUpModule } from './patient-sign-up/patient-sign-up.module';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { routes } from './routes';
import { ReversePipe } from './reverse.pipe';

@NgModule({
  declarations: [
    AppComponent 
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    SharedModule,
    FormsModule,
    AccountModule, 
    DaConsultationModule, DaHomeModule, DaNewPatientModule, DaOnePatientModule,
    ReDocReportModule, ReHomeModule, RePatReportModule,
    MdrHomeModule, MdrViewDataModule, LogInModule, PatientSignUpModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
