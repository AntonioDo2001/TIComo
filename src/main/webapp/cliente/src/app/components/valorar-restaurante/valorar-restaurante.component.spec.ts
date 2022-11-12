import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValorarRestauranteComponent } from './valorar-restaurante.component';

describe('ValorarRestauranteComponent', () => {
  let component: ValorarRestauranteComponent;
  let fixture: ComponentFixture<ValorarRestauranteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ValorarRestauranteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ValorarRestauranteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
