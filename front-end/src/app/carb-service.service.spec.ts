import { TestBed } from '@angular/core/testing';

import { CarbServiceService } from './carb-service.service';

describe('CarbServiceService', () => {
  let service: CarbServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarbServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
