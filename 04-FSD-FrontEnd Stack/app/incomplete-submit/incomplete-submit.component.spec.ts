import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IncompleteSubmitComponent } from './incomplete-submit.component';

describe('IncompleteSubmitComponent', () => {
  let component: IncompleteSubmitComponent;
  let fixture: ComponentFixture<IncompleteSubmitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IncompleteSubmitComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IncompleteSubmitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
