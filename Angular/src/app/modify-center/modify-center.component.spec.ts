import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyCenterComponent } from './modify-center.component';

describe('ModifyCenterComponent', () => {
  let component: ModifyCenterComponent;
  let fixture: ComponentFixture<ModifyCenterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifyCenterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
