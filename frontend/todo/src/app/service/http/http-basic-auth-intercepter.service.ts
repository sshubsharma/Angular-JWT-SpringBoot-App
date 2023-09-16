import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { BasicAuthService } from './basic-auth.service';

@Injectable({
  providedIn: 'root'
})
export class HttpBasicAuthIntercepterService implements HttpInterceptor{

  constructor(
    private basicAuthService: BasicAuthService

  ) { }

  intercept(request: HttpRequest<any>, next: HttpHandler){

    // let username='user'
    // let password='dummy'
    // let basicAuthHeaderString='Basic ' + window.btoa(`${username} + ':' + ${password}`) 
    let basicAuthHeaderString=this.basicAuthService.getAuthenticatedToken();
    let userName=this.basicAuthService.getAuthenticatedUser();
    if(basicAuthHeaderString && userName){
      request.clone({
        setHeaders : {
            Authorization : basicAuthHeaderString
        }
  
      })
    }
    return next.handle(request);
  }

}
