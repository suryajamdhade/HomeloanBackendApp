import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JwtResponse } from './admin/model/JwtResponse';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private loginUrl = 'http://localhost:9091/login';

  constructor(private http: HttpClient) { }


  login(username: string, password: string ) : Observable<JwtResponse>{
    const url = `${this.loginUrl}?username=${username}&password=${password}`;
    return this.http.post<JwtResponse>(url, {});
  }
}
