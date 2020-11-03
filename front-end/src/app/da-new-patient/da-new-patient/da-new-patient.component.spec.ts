import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DaNewPatientComponent } from './da-new-patient.component';

describe('DaNewPatientComponent', () => {
  let component: DaNewPatientComponent;
  let fixture: ComponentFixture<DaNewPatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DaNewPatientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DaNewPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
