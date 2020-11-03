import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MdrViewDataComponent } from './mdr-view-data.component';

describe('MdrViewDataComponent', () => {
  let component: MdrViewDataComponent;
  let fixture: ComponentFixture<MdrViewDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MdrViewDataComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MdrViewDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
