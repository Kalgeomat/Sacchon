import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MdrViewDataComponent } from './mdr-view-data/mdr-view-data.component';
import { FormsModule } from '../forms/forms.module';



@NgModule({
  declarations: [MdrViewDataComponent],
  imports: [
    CommonModule, FormsModule
  ],
  exports: [
    MdrViewDataComponent
  ]
})
export class MdrViewDataModule { }
