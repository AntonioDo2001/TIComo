import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarEntregasRiderComponent } from './listar-entregas-rider.component';

describe('ListarEntregasRiderComponent', () => {
  let component: ListarEntregasRiderComponent;
  let fixture: ComponentFixture<ListarEntregasRiderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarEntregasRiderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarEntregasRiderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
