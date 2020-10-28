import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DaConsultationComponent } from './da-consultation/da-consultation.component';



@NgModule({
  declarations: [DaConsultationComponent],
  imports: [
    CommonModule
  ],
  exports: [
    DaConsultationComponent
  ]
})
export class DaConsultationModule { }
