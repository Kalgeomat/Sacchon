import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RePatReportComponent } from './re-pat-report.component';

describe('RePatReportComponent', () => {
  let component: RePatReportComponent;
  let fixture: ComponentFixture<RePatReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RePatReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RePatReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
