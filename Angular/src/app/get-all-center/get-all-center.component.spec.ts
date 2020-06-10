import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllCenterComponent } from './get-all-center.component';

describe('GetAllCenterComponent', () => {
  let component: GetAllCenterComponent;
  let fixture: ComponentFixture<GetAllCenterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllCenterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
