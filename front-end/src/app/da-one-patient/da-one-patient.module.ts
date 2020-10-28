import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DaOnePatientComponent } from './da-one-patient/da-one-patient.component';



@NgModule({
  declarations: [DaOnePatientComponent],
  imports: [
    CommonModule
  ],
  exports: [
    DaOnePatientComponent
  ]
})
export class DaOnePatientModule { }
