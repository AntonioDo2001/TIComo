import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarAdminsComponent } from './listar-admins.component';

describe('ListarAdminsComponent', () => {
  let component: ListarAdminsComponent;
  let fixture: ComponentFixture<ListarAdminsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarAdminsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarAdminsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
