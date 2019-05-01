import { TestBed, inject } from '@angular/core/testing';

import { MafiaServiceService } from './mafia-service.service';

describe('MafiaServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MafiaServiceService]
    });
  });

  it('should be created', inject([MafiaServiceService], (service: MafiaServiceService) => {
    expect(service).toBeTruthy();
  }));
});
