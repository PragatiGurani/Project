import { Component, OnInit } from '@angular/core';
import { CenterService } from '../center.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-modify-center',
  templateUrl: './modify-center.component.html',
  styleUrls: ['./modify-center.component.css']
})
export class ModifyCenterComponent implements OnInit {

  success: string;
  failure: string;

  centerId1;
  centerName1;

  constructor(public centerService: CenterService,
              private router: Router,
              private activatedRouter: ActivatedRoute) {
      activatedRouter.params.subscribe( data => {
        console.log(data.centerId);
        this.centerId1 = data.centerId;
      });

      activatedRouter.queryParams.subscribe( data => {
        console.log(data);
        this.centerId1 = data.centerId;
        this.centerName1 = data.centerName;
             });
     }

     modifyCenter(form: NgForm) {
      console.log(form.value);
      this.centerService.modifyCenter(form.value).subscribe(data => {
        console.log(data);
        this.router.navigateByUrl('/get-all-center');
      });
    }

  ngOnInit(): void {
  }

}
