import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReDocReportComponent } from './re-doc-report.component';

describe('ReDocReportComponent', () => {
  let component: ReDocReportComponent;
  let fixture: ComponentFixture<ReDocReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReDocReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReDocReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
