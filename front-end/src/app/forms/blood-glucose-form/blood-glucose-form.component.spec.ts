import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodGlucoseFormComponent } from './blood-glucose-form.component';

describe('BloodGlucoseFormComponent', () => {
  let component: BloodGlucoseFormComponent;
  let fixture: ComponentFixture<BloodGlucoseFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BloodGlucoseFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BloodGlucoseFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
