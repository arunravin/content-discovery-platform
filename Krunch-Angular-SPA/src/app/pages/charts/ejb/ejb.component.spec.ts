import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EjbComponent } from './ejb.component';

describe('EjbComponent', () => {
  let component: EjbComponent;
  let fixture: ComponentFixture<EjbComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EjbComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EjbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
