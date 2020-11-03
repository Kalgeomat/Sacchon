import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReDocReportComponent } from './re-doc-report/re-doc-report.component';
import { FormsModule } from '../forms/forms.module';




@NgModule({
  declarations: [ReDocReportComponent],
  imports: [
    CommonModule, FormsModule
  ],
  exports: [
    ReDocReportComponent
  ]
})
export class ReDocReportModule { }
