import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarEntregasClienteComponent } from './listar-entregas-cliente.component';

describe('ListarEntregasClienteComponent', () => {
  let component: ListarEntregasClienteComponent;
  let fixture: ComponentFixture<ListarEntregasClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarEntregasClienteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarEntregasClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
