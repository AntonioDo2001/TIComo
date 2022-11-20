import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerValoracionesRestauranteAdminComponent } from './ver-valoraciones-restaurante-admin.component';

describe('VerValoracionesRestauranteAdminComponent', () => {
  let component: VerValoracionesRestauranteAdminComponent;
  let fixture: ComponentFixture<VerValoracionesRestauranteAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VerValoracionesRestauranteAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VerValoracionesRestauranteAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
