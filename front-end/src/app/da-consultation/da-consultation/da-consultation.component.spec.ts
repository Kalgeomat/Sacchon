import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DaConsultationComponent } from './da-consultation.component';

describe('DaConsultationComponent', () => {
  let component: DaConsultationComponent;
  let fixture: ComponentFixture<DaConsultationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DaConsultationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DaConsultationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
