import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { HttpParams } from '@angular/common/http';
import {User} from './user';
import {Dot} from './dot';
import { Observable, of } from 'rxjs';


@Injectable()
export class HttpService {

  constructor(private http: HttpClient) { }

  getUser() {
    return this.http.get('assets/user.json');
  }

  // getDots(dots: Dots) {
  //   const body = {x: dots.x, y: dots.y, r: dots.r, result: dots.result, executionTime: dots.executionTime, userTime: dots.userTime};
  //   return this.http.post('http://localhost:8080/web/zone/dots', body);
  // }
  getDots() {
    return this.http.get('assets/dots.json');
  }


  login(url: string) {
    return this.http.get(url, {withCredentials: true, observe: 'response'});
  }

  unlogin() {
    return this.http.get('http://localhost:8080/namedJIOJI/web/sign/out', {withCredentials: true});
  }

  register(url: string) {
    return this.http.get(url, {withCredentials: true, observe: 'response'});
  }

  addDot(url: string) {
    return this.http.get(url, {withCredentials: true, observe: 'response'});
  }

  getDotsList(): Observable<HttpResponse<Dot[]>> {
    // tslint:disable-next-line:max-line-length
    return this.http.get<Dot[]>('http://localhost:8080/namedJIOJI/web/dotdata/read', { withCredentials: true, observe: 'response' });
  }
}
