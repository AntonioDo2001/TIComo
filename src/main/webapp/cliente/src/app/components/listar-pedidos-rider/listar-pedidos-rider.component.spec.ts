import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarPedidosRiderComponent } from './listar-pedidos-rider.component';

describe('ListarPedidosRiderComponent', () => {
  let component: ListarPedidosRiderComponent;
  let fixture: ComponentFixture<ListarPedidosRiderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarPedidosRiderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarPedidosRiderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
