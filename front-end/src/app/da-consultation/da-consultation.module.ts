import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DaConsultationComponent } from './da-consultation/da-consultation.component';
import { FormsModule } from '../forms/forms.module';



@NgModule({
  declarations: [DaConsultationComponent],
  imports: [
    CommonModule, FormsModule
  ],
  exports: [
    DaConsultationComponent
  ]
})
export class DaConsultationModule { }
