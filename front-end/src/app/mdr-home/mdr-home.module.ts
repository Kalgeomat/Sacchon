import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MdrHomeComponent } from './mdr-home/mdr-home.component';
import { FormsModule } from '../forms/forms.module';




@NgModule({
  declarations: [MdrHomeComponent],
  imports: [
    CommonModule, FormsModule
  ],
  exports: [
    MdrHomeComponent
  ]
})
export class MdrHomeModule { }
