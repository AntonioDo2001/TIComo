import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarRidersComponent } from './listar-riders.component';

describe('ListarRidersComponent', () => {
  let component: ListarRidersComponent;
  let fixture: ComponentFixture<ListarRidersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarRidersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarRidersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
