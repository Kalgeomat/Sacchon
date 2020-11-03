import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupDoctorFormComponent } from './signup-doctor-form.component';

describe('SignupDoctorFormComponent', () => {
  let component: SignupDoctorFormComponent;
  let fixture: ComponentFixture<SignupDoctorFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SignupDoctorFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupDoctorFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
