import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllTestComponent } from './get-all-test.component';

describe('GetAllTestComponent', () => {
  let component: GetAllTestComponent;
  let fixture: ComponentFixture<GetAllTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
