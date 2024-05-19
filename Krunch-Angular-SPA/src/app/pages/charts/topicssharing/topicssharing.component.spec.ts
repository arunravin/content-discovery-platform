import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TopicssharingComponent } from './topicssharing.component';

describe('TopicssharingComponent', () => {
  let component: TopicssharingComponent;
  let fixture: ComponentFixture<TopicssharingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TopicssharingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopicssharingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
