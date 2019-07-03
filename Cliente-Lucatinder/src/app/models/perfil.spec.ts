import { TestBed } from '@angular/core/testing';

import { ModelsService } from './perfil';

describe('ModelsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ModelsService = TestBed.get(ModelsService);
    expect(service).toBeTruthy();
  });
});
