import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NarratorScreenComponent } from './narrator-screen.component';

describe('NarratorScreenComponent', () => {
  let component: NarratorScreenComponent;
  let fixture: ComponentFixture<NarratorScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NarratorScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NarratorScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
