import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarRestaurantesClienteComponent } from './listar-restaurantes-cliente.component';

describe('ListarRestaurantesClienteComponent', () => {
  let component: ListarRestaurantesClienteComponent;
  let fixture: ComponentFixture<ListarRestaurantesClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarRestaurantesClienteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarRestaurantesClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
