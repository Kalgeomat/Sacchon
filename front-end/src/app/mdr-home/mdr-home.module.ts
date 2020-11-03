import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MdrHomeComponent } from './mdr-home/mdr-home.component';
import { FormsModule } from '../forms/forms.module';
import { ReactiveFormsModule } from '@angular/forms';
import { LogInComponent } from '../log-in/log-in/log-in.component';
import { LogInModule } from '../log-in/log-in.module';




@NgModule({
  declarations: [MdrHomeComponent],
  imports: [
    CommonModule, FormsModule, ReactiveFormsModule
  ],
  exports: [
    MdrHomeComponent
  ]
})
export class MdrHomeModule { }
