import { Component, OnInit } from '@angular/core';
import { TestService } from '../test.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-test',
  templateUrl: './get-all-test.component.html',
  styleUrls: ['./get-all-test.component.css']
})
export class GetAllTestComponent implements OnInit {

  success: string;
  failure: string;
   tests: Test[];

  constructor(private testSer: TestService,
              private router: Router) {
        this.getAllTest();
     }

     deleteTest(test: Test) {
      this.testSer.deleteTest(test).subscribe(data => {
        console.log(data);
        if (data.statusCode === 201) {
          this.tests.splice(this.tests.indexOf(test), 1);
          this.success = data.description;
          setTimeout(() => {
              this.success = null;
          }, 2000);
        }
      });
    }

     getAllTest() {
      this.testSer.getAllTest().subscribe(response => {
        console.log(response);
        if (response.statusCode === 201) {
          this.tests = response.bean;
          this.success = response.description;
          localStorage.setItem('test Details', JSON.stringify(response));
          setTimeout(() => {
            this.success = null;
          }, 3000);
        } else {
          this.failure = response.description;
          localStorage.setItem('test Details', JSON.stringify(response));
          console.log('test Details are Added');
          setTimeout(() => {
            this.failure = null;
          }, 3000);
        }
      });
    }

    modifyTest(tests) {
      this.router.navigate([`/modify-test/${tests.testId}`],
      { queryParams: {
        testName: tests.testName,
        centerId: tests.centerId
      }}
      );
    }

  ngOnInit(): void {
  }

}
