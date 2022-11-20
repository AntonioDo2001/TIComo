import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RealizarValoracionComponent } from './realizar-valoracion.component';

describe('RealizarValoracionComponent', () => {
  let component: RealizarValoracionComponent;
  let fixture: ComponentFixture<RealizarValoracionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RealizarValoracionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RealizarValoracionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
