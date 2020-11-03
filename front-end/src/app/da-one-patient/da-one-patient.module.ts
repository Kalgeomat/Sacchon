import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DaOnePatientComponent } from './da-one-patient/da-one-patient.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ReversePipe } from '../reverse.pipe';



@NgModule({
  declarations: [DaOnePatientComponent],
  imports: [
    CommonModule, 
    FormsModule, ReactiveFormsModule
  ],
  exports: [
    DaOnePatientComponent
  ]
})
export class DaOnePatientModule { }
