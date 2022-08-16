import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateViewSlotComponent } from './create-view-slot.component';

describe('CreateViewSlotComponent', () => {
  let component: CreateViewSlotComponent;
  let fixture: ComponentFixture<CreateViewSlotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateViewSlotComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateViewSlotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
