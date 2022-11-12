import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaPagoPedidoComponent } from './pagina-pago-pedido.component';

describe('PaginaPagoPedidoComponent', () => {
  let component: PaginaPagoPedidoComponent;
  let fixture: ComponentFixture<PaginaPagoPedidoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaginaPagoPedidoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaginaPagoPedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
