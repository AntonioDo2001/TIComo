import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PantallaCargaInicialComponent } from './pantalla-carga-inicial.component';

describe('PantallaCargaInicialComponent', () => {
  let component: PantallaCargaInicialComponent;
  let fixture: ComponentFixture<PantallaCargaInicialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PantallaCargaInicialComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PantallaCargaInicialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
