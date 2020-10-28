import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DaHomeComponent } from './da-home/da-home.component';
import { SharedModule } from '../shared/shared.module';



@NgModule({
  declarations: [DaHomeComponent],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    DaHomeComponent
  ]
})
export class DaHomeModule { }

