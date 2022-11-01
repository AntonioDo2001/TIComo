import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarPlatosComponent } from './listar-platos.component';

describe('ListarPlatosComponent', () => {
  let component: ListarPlatosComponent;
  let fixture: ComponentFixture<ListarPlatosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarPlatosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarPlatosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
