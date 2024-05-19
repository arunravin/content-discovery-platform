import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyassignmentComponent } from './myassignment.component';

describe('MyassignmentComponent', () => {
  let component: MyassignmentComponent;
  let fixture: ComponentFixture<MyassignmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyassignmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyassignmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
