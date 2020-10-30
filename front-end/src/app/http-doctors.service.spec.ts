import { TestBed } from '@angular/core/testing';

import { HttpDoctorsService } from './http-doctors.service';

describe('HttpDoctorsService', () => {
  let service: HttpDoctorsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpDoctorsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
