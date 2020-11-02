import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MDRViewDataPageComponent } from './mdr-view-data-page.component';

describe('MDRViewDataPageComponent', () => {
  let component: MDRViewDataPageComponent;
  let fixture: ComponentFixture<MDRViewDataPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MDRViewDataPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MDRViewDataPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
