import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MdrPastConsultationsComponent } from './mdr-past-consultations/mdr-past-consultations.component';



@NgModule({
  declarations: [MdrPastConsultationsComponent],
  imports: [
    CommonModule
  ],
  exports: [
    MdrPastConsultationsComponent
  ]
})
export class MdrPastConsultationsModule { }
