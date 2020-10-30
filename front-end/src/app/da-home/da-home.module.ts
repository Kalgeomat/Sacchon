import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DaHomeComponent } from './da-home/da-home.component';
import { SharedModule } from '../shared/shared.module';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [DaHomeComponent],
  imports: [
    CommonModule,
    SharedModule, 
    FormsModule
  ],
  exports: [
    DaHomeComponent
  ]
})
export class DaHomeModule { }

