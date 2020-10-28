import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarbIntakeFormComponent } from './carb-intake-form.component';

describe('CarbIntakeFormComponent', () => {
  let component: CarbIntakeFormComponent;
  let fixture: ComponentFixture<CarbIntakeFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarbIntakeFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarbIntakeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
