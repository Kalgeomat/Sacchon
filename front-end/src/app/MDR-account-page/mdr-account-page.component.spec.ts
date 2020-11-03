import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MDRAccountPageComponent } from './mdr-account-page.component';

describe('MDRAccountPageComponent', () => {
  let component: MDRAccountPageComponent;
  let fixture: ComponentFixture<MDRAccountPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MDRAccountPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MDRAccountPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
