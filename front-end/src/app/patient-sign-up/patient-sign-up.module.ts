import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PatientSignUpComponent } from './patient-sign-up/patient-sign-up.component';
import { FormsModule } from '../forms/forms.module';



@NgModule({
  declarations: [PatientSignUpComponent],
  imports: [
    CommonModule, FormsModule
  ],
  exports: [
    PatientSignUpComponent
  ]
})
export class PatientSignUpModule { }
