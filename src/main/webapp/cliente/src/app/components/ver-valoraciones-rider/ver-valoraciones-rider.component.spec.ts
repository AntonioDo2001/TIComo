import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerValoracionesRiderComponent } from './ver-valoraciones-rider.component';

describe('VerValoracionesRiderComponent', () => {
  let component: VerValoracionesRiderComponent;
  let fixture: ComponentFixture<VerValoracionesRiderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VerValoracionesRiderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VerValoracionesRiderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
