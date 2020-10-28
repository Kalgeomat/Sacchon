import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DaAccountComponent } from './da-account.component';

describe('DaAccountComponent', () => {
  let component: DaAccountComponent;
  let fixture: ComponentFixture<DaAccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DaAccountComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DaAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
