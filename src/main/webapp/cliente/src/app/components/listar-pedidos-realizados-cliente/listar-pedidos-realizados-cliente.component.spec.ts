import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarPedidosRealizadosClienteComponent } from './listar-pedidos-realizados-cliente.component';

describe('ListarPedidosRealizadosClienteComponent', () => {
  let component: ListarPedidosRealizadosClienteComponent;
  let fixture: ComponentFixture<ListarPedidosRealizadosClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarPedidosRealizadosClienteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarPedidosRealizadosClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
