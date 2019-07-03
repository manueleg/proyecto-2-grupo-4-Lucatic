import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilMatchComponent } from './perfil-match.component';

describe('PerfilMatchComponent', () => {
  let component: PerfilMatchComponent;
  let fixture: ComponentFixture<PerfilMatchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PerfilMatchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PerfilMatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
