import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private loginUrl = 'http://localhost:9091/login';

  constructor(private http: HttpClient) { }


  login(username: string, password: string ){
    const url = `${this.loginUrl}?username=${username}&password=${password}`;
    return this.http.get(url, { responseType: 'text' });
  }
}
