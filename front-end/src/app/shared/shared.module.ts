import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [HeaderComponent, FooterComponent, NavbarComponent],
  imports: [
    CommonModule, ReactiveFormsModule, FormsModule
  ],
  exports: [
    FooterComponent,
    HeaderComponent,
    NavbarComponent
  ]
})
export class SharedModule { }
