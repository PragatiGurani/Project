import { Component, OnInit } from '@angular/core';
import { TestService } from '../test.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-modify-test',
  templateUrl: './modify-test.component.html',
  styleUrls: ['./modify-test.component.css']
})
export class ModifyTestComponent implements OnInit {

  success: string;
  failure: string;

  testId1;
  testName1;
  centerId1;

  constructor(public testService: TestService,
              private router: Router,
              private activatedRouter: ActivatedRoute) {
    activatedRouter.params.subscribe(data => {
      console.log(data.testId);
      this.testId1 = data.testId;
    });

    activatedRouter.queryParams.subscribe(data => {
      console.log(data);
      this.testName1 = data.testName;
      this.centerId1 = data.centerId;
    });
  }

  modifyTest(form: NgForm) {
    console.log(form.value);
    this.testService.modifyTest(form.value).subscribe(data => {
      console.log(data);
      this.router.navigateByUrl('/get-all-test');
    });
  }

  ngOnInit(): void {
  }

}
