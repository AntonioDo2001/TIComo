import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearRiderComponent } from './crear-rider.component';

describe('CrearRiderComponent', () => {
  let component: CrearRiderComponent;
  let fixture: ComponentFixture<CrearRiderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearRiderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CrearRiderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
