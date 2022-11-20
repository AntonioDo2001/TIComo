import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerValoracionesRestauranteComponent } from './ver-valoraciones-restaurante.component';

describe('VerValoracionesRestauranteComponent', () => {
  let component: VerValoracionesRestauranteComponent;
  let fixture: ComponentFixture<VerValoracionesRestauranteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VerValoracionesRestauranteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VerValoracionesRestauranteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
