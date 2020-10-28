import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DaAccountComponent } from './da-account/da-account.component';



@NgModule({
  declarations: [DaAccountComponent],
  imports: [
    CommonModule
  ],
  exports: [
    DaAccountComponent
  ]
})
export class DaAccountModule { }
