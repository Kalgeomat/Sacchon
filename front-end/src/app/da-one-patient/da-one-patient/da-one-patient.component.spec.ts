import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DaOnePatientComponent } from './da-one-patient.component';

describe('DaOnePatientComponent', () => {
  let component: DaOnePatientComponent;
  let fixture: ComponentFixture<DaOnePatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DaOnePatientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DaOnePatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
