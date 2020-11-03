import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MdrHomeComponent } from './mdr-home.component';

describe('MdrHomeComponent', () => {
  let component: MdrHomeComponent;
  let fixture: ComponentFixture<MdrHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MdrHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MdrHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
