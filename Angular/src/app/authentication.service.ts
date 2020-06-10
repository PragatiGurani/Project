import { Injectable } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

   login(userDetails): Observable<any> {
    return this.http.post<any>(`${this.url}/auth-Admin`, userDetails);
  }
}
