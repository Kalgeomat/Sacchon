import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RePatReportComponent } from './re-pat-report/re-pat-report.component';
import { FormsModule } from '../forms/forms.module';



@NgModule({
  declarations: [RePatReportComponent],
  imports: [
    CommonModule, FormsModule
  ],
  exports: [
    RePatReportComponent
  ]
})
export class RePatReportModule { }
