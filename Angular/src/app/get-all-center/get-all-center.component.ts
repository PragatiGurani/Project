import { Component, OnInit } from '@angular/core';
import { CenterService } from '../center.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-center',
  templateUrl: './get-all-center.component.html',
  styleUrls: ['./get-all-center.component.css']
})
export class GetAllCenterComponent implements OnInit {

  success: string;
  failure: string;
  centers: Center[];

  constructor(private centerSer: CenterService,
              private router: Router) {
                 this.getAllCenter();
               }

               deleteCenter(center: Center) {
                this.centerSer.deleteCenter(center).subscribe(data => {
                  console.log(data);
                  if (data.statusCode === 201) {
                    this.centers.splice(this.centers.indexOf(center), 1);
                    this.success = data.description;
                    setTimeout(() => {
                        this.success = null;
                    }, 2000);
                  }
                });
              }

               getAllCenter() {
                this.centerSer.getAllCenter().subscribe(response => {
                  console.log(response);
                  if (response.statusCode === 201) {
                    this.centers = response.bean;
                    this.success = response.description;
                    localStorage.setItem('center Details', JSON.stringify(response));
                    setTimeout(() => {
                      this.success = null;
                    }, 3000);
                  } else {
                    this.failure = response.description;
                    localStorage.setItem('center Details', JSON.stringify(response));
                    console.log('center Details are Added');
                    setTimeout(() => {
                      this.failure = null;
                    }, 3000);
                  }
                });
              }

              modifyCenter(centers) {
                this.router.navigate([`/modify-center/${centers.centerId}`],
                { queryParams: {
                  centerId: centers.centerId,
                  centerName: centers.centerName
                }}
                );
              }
  ngOnInit(): void {
  }
}
