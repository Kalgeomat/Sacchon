import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReHomeComponent } from './re-home/re-home.component';



@NgModule({
  declarations: [ReHomeComponent],
  imports: [
    CommonModule
  ],
  exports: [
    ReHomeComponent
  ]
})
export class ReHomeModule { }
