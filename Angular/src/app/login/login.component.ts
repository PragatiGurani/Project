import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  success: string;
  failure: string;
  error: string;

  constructor(private admin: AuthenticationService,
              private router: Router) { }

  ngOnInit(): void {
  }

  login(form: NgForm) {
    this.admin.login(form.value).subscribe(data => {
      console.log(data);

      if (data.statusCode === 201) {
        this.success = data.description;
        localStorage.setItem('userDetails', JSON.stringify(data));
        console.log('user Details stored in local storage');
        this.router.navigateByUrl('/');

      } else {
        this.failure = data.description;
        localStorage.setItem('userDetails', JSON.stringify(data));
        setTimeout(() => {
          this.success = null;
        }, 3000);
      }
    });
  }

}
