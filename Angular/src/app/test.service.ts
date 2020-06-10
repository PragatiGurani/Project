import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  addTest(testDetails): Observable<any> {
    return this.http.post<any>(`${this.url}/add-test`, testDetails);
  }

  modifyTest(testDetails) {
   return this.http.put<any>(`${this.url}/modify-test`, testDetails);
  }

  getAllTest(): Observable<any> {
    return this.http.get<any>(`${this.url}/getAll-test`);
  }

  deleteTest(test: Test) {
    return this.http.delete<any>(`${this.url}/delete-test/${test.centerId}`);
  }
}
