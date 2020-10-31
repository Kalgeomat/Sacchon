import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DaOnePatientComponent } from './da-one-patient/da-one-patient.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [DaOnePatientComponent],
  imports: [
    CommonModule, 
    FormsModule
  ],
  exports: [
    DaOnePatientComponent
  ]
})
export class DaOnePatientModule { }
