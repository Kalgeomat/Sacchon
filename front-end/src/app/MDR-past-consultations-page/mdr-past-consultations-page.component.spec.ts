import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MDRPastConsultationsPageComponent } from './mdr-past-consultations-page.component';

describe('MDRPastConsultationsPageComponent', () => {
  let component: MDRPastConsultationsPageComponent;
  let fixture: ComponentFixture<MDRPastConsultationsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MDRPastConsultationsPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MDRPastConsultationsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
