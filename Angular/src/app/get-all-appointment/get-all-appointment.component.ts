import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-appointment',
  templateUrl: './get-all-appointment.component.html',
  styleUrls: ['./get-all-appointment.component.css']
})
export class GetAllAppointmentComponent implements OnInit {

  success: string;
  failure: string;
  appointments: Appointment[];

  constructor(private appointmentSer: AppointmentService,
              private router: Router) {
                this.getAllAppointment();
               }

              getAllAppointment() {
                this.appointmentSer.getAllAppointment().subscribe(response => {
                  console.log(response);
                  if (response.statusCode === 201) {
                    this.appointments = response.bean;
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
             
              approveAppointment(appointments) {
                this.router.navigate([`/approve-appointment/${appointments.appointmentId}`],
                { queryParams: {
                  userId: appointments.userId,
                  userName: appointments.userName,
                  testName: appointments.testName,
                  dateTime: appointments.dateTime,
                  centerId: appointments.centerId,
                  appointmentStatus: appointments.appointmentStatus
                }}
                );
              }

  ngOnInit(): void {
  }

}
