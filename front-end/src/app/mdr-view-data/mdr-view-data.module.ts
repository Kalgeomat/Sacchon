import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MdrViewDataComponent } from './mdr-view-data/mdr-view-data.component';
import { FormsModule } from '../forms/forms.module';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [MdrViewDataComponent],
  imports: [
    CommonModule, FormsModule, ReactiveFormsModule
  ],
  exports: [
    MdrViewDataComponent
  ]
})
export class MdrViewDataModule { }
