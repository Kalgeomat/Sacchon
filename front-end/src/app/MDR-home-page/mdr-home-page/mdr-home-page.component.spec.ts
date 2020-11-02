import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MDRHomePageComponent } from './mdr-home-page.component';

describe('MDRHomePageComponent', () => {
  let component: MDRHomePageComponent;
  let fixture: ComponentFixture<MDRHomePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MDRHomePageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MDRHomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
