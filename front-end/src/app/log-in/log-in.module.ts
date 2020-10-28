import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LogInComponent } from './log-in/log-in.component';
import { FormsModule } from '../forms/forms.module';



@NgModule({
  declarations: [LogInComponent],
  imports: [
    CommonModule, FormsModule
  ],
  exports: [
    LogInComponent
  ]
})
export class LogInModule { }
