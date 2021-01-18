import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendidoComponent } from './vendido.component';

describe('VendidoComponent', () => {
  let component: VendidoComponent;
  let fixture: ComponentFixture<VendidoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VendidoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VendidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
