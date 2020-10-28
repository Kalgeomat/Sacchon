import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DaNewPatientComponent } from './da-new-patient/da-new-patient.component';



@NgModule({
  declarations: [DaNewPatientComponent],
  imports: [
    CommonModule
  ],
  exports: [
    DaNewPatientComponent
  ]
})
export class DaNewPatientModule { }
