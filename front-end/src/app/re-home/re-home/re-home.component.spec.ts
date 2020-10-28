import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReHomeComponent } from './re-home.component';

describe('ReHomeComponent', () => {
  let component: ReHomeComponent;
  let fixture: ComponentFixture<ReHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
