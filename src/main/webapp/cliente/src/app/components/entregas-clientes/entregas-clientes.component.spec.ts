import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntregasClientesComponent } from './entregas-clientes.component';

describe('EntregasClientesComponent', () => {
  let component: EntregasClientesComponent;
  let fixture: ComponentFixture<EntregasClientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EntregasClientesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EntregasClientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
