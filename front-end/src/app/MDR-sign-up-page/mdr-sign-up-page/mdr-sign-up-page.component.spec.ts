import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MDRSignUpPageComponent } from './mdr-sign-up-page.component';

describe('MDRSignUpPageComponent', () => {
  let component: MDRSignUpPageComponent;
  let fixture: ComponentFixture<MDRSignUpPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MDRSignUpPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MDRSignUpPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
