import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginFormComponent } from './login-form/login-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SignupPatientFormComponent } from './signup-patient-form/signup-patient-form.component';
import { SignupDoctorFormComponent } from './signup-doctor-form/signup-doctor-form.component';
import { BloodGlucoseFormComponent } from './blood-glucose-form/blood-glucose-form.component';
import { CarbIntakeFormComponent } from './carb-intake-form/carb-intake-form.component';
import { PeriodFormComponent } from './period-form/period-form.component';
import { ConsultationFormComponent } from './consultation-form/consultation-form.component';

@NgModule({
  declarations: [
    LoginFormComponent, SignupPatientFormComponent, SignupDoctorFormComponent, 
    BloodGlucoseFormComponent, CarbIntakeFormComponent, PeriodFormComponent, ConsultationFormComponent
  ],
  imports: [
    CommonModule, ReactiveFormsModule
  ],
  exports:[
    LoginFormComponent, SignupPatientFormComponent, SignupDoctorFormComponent, BloodGlucoseFormComponent, 
    CarbIntakeFormComponent, ConsultationFormComponent, PeriodFormComponent
  ]
})
export class FormsModule { }
