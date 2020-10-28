import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { FormsModule } from './forms/forms.module';
import { DaAccountModule } from './da-account/da-account.module';
import { DaConsultationModule } from './da-consultation/da-consultation.module';
import { DaHomeModule } from './da-home/da-home.module';
import { DaNewPatientModule } from './da-new-patient/da-new-patient.module';
import { DaOnePatientModule } from './da-one-patient/da-one-patient.module';
import { DaHomeComponent } from './da-home/da-home/da-home.component';
import { ReDocReportModule } from './re-doc-report/re-doc-report.module';
import { ReHomeModule } from './re-home/re-home.module';
import { RePatReportModule } from './re-pat-report/re-pat-report.module';

@NgModule({
  declarations: [
    AppComponent    
  ],
  imports: [
    BrowserModule,
    SharedModule,
    FormsModule,
    DaAccountModule, DaConsultationModule, DaHomeModule, DaNewPatientModule, DaOnePatientModule,
    ReDocReportModule, ReHomeModule, RePatReportModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
