import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-approve-appointment',
  templateUrl: './approve-appointment.component.html',
  styleUrls: ['./approve-appointment.component.css']
})
export class ApproveAppointmentComponent implements OnInit {

  success: string;
  failure: string;

  appointmentId1;
  userId1;
  userName1;
  testName1;
  dateTime1;
  centerId1;
  appointmentStatus1;

  constructor(public appointmentService: AppointmentService,
              private router: Router,
              private activatedRouter: ActivatedRoute) {
      activatedRouter.params.subscribe( data => {
        console.log(data.testId);
        this.appointmentId1 = data.appointmentId;
      });

      activatedRouter.queryParams.subscribe( data => {
        console.log(data);
        this.userId1 = data.userId;
        this.userName1 = data.userName;
        this.testName1 = data.testName;
        this.dateTime1 = data.dateTime;
        this.centerId1 = data.centerId;
        this.appointmentStatus1 = data.appointmentStatus1;

      });
     }

     approveAppointment(form: NgForm) {
      console.log(form.value);
      this.appointmentService.approveAppointment(form.value).subscribe(data => {
        console.log(data);
        this.router.navigateByUrl('/get-all-appointment');
      });
    }

  ngOnInit(): void {
  }

}
