import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarPlatosClienteComponent } from './listar-platos-cliente.component';

describe('ListarPlatosClienteComponent', () => {
  let component: ListarPlatosClienteComponent;
  let fixture: ComponentFixture<ListarPlatosClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarPlatosClienteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarPlatosClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
