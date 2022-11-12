import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValorarRiderComponent } from './valorar-rider.component';

describe('ValorarRiderComponent', () => {
  let component: ValorarRiderComponent;
  let fixture: ComponentFixture<ValorarRiderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ValorarRiderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ValorarRiderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
