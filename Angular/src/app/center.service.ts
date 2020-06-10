import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CenterService {

  url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  addCenter(centerDetails): Observable<any> {
    return this.http.post<any>(`${this.url}/add-center`, centerDetails);
  }

  modifyCenter(centerDetails) {
   return this.http.put<any>(`${this.url}/modify-center`, centerDetails);
  }

  getAllCenter(): Observable<any> {
    return this.http.get<any>(`${this.url}/getAll-center`);
  }

  deleteCenter(center: Center) {
    return this.http.delete<any>(`${this.url}/delete-center/${center.centerId}`);
  }


}
