import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupPatientFormComponent } from './signup-patient-form.component';

describe('SignupPatientFormComponent', () => {
  let component: SignupPatientFormComponent;
  let fixture: ComponentFixture<SignupPatientFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SignupPatientFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupPatientFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
