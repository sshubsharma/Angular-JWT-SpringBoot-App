import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';
import { API_URL } from 'src/app/app.constants';

export class AuthenticationBean{
  constructor(
    public  message:string
  ){

  }
  
}

@Injectable({
  providedIn: 'root'
})
export class BasicAuthService {

  constructor(private httpClient:HttpClient) { 
    

  }


  //jwt method

  executejwtAuthenticationService(username: string ,password: string){
   
    return this.httpClient.post<any>(`${API_URL}/authenticate`,{
   username,
   password}).pipe(
      map(
         data=>{
          sessionStorage.setItem('authUser',username);
          sessionStorage.setItem('token',`Bearer ${data.token}`);
          return data;
         }
      )
    );
   }

  executeBasicAuthenticationService(username: string ,password: string){
    let basicAuthHeaderString='Basic ' + window.btoa(username + ':' + password)    
    let headers=new HttpHeaders({
        Authrization:basicAuthHeaderString
    })

    return this.httpClient.get<AuthenticationBean>(`${API_URL}/basicauth`,
    {headers}).pipe(
      map(
         data=>{
          sessionStorage.setItem('authUser',username);
          sessionStorage.setItem('token',basicAuthHeaderString);
          return data;
         }
      )
    );
   }

  // authenticate(username: string ,password: string){
  //   if(username==="shubham" && password==='dummy'){
  //     sessionStorage.setItem('authUser',username);
  //     return true;
  //   }
  //     return false;
  // }

  getAuthenticatedUser(){
    return sessionStorage.getItem('authUser');
    
  }
  getAuthenticatedToken(){
    if(this.getAuthenticatedUser())
     return sessionStorage.getItem('token');
    else
    return null;
  }


  isUserLogedIn(){
    let user=sessionStorage.getItem('authUser');
    return !(user===null)
  }

  logout(){
    sessionStorage.removeItem('authUser');
    sessionStorage.removeItem('token');
  }

  createBasicAuthenticationHeader(){
    let username='shubham'
    let password='dummy'
    let basicAuthString='Basic ' + window.btoa(username + ':' + password)  
    return basicAuthString;
  }

  
}
