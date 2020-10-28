import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MdrPastConsultationsComponent } from './mdr-past-consultations.component';

describe('MdrPastConsultationsComponent', () => {
  let component: MdrPastConsultationsComponent;
  let fixture: ComponentFixture<MdrPastConsultationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MdrPastConsultationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MdrPastConsultationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
