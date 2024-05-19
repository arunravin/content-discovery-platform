import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TopicdataviewComponent } from './topicdataview.component';

describe('TopicdataviewComponent', () => {
  let component: TopicdataviewComponent;
  let fixture: ComponentFixture<TopicdataviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TopicdataviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopicdataviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
