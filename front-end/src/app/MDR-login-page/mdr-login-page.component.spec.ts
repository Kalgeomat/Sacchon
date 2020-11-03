import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MDRLoginPageComponent } from './mdr-login-page.component';

describe('MDRLoginPageComponent', () => {
  let component: MDRLoginPageComponent;
  let fixture: ComponentFixture<MDRLoginPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MDRLoginPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MDRLoginPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
