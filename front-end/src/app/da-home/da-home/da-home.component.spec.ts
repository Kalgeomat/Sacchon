import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DaHomeComponent } from './da-home.component';

describe('DaHomeComponent', () => {
  let component: DaHomeComponent;
  let fixture: ComponentFixture<DaHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DaHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DaHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
