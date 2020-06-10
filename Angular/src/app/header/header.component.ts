import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) { }

  isAdmin() {
      const details = JSON.parse(localStorage.getItem('userDetails'));
      if (details && details.loginType === 'Admin') {
        return true;
      } else {
        return false;
      }
    }

    isLoggedIn() {
      const details = JSON.parse(localStorage.getItem('userDetails'));
      if (details) {
        return true;
      } else {
        return false;
      }
    }

    isLoggedOut() {
      localStorage.removeItem('userDetails');
      this.router.navigateByUrl('/login');
    }

  ngOnInit(): void {
  }

}
