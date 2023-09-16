import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { API_URL } from 'src/app/app.constants';


export class HelloWorldbean{
  constructor(
    public  message:string
  ){

  }
  
}

@Injectable({
  providedIn: 'root'
})


export class WelcomeDataService {

  constructor(
    private httpClient:HttpClient
  ) { }

  executeHelloWordService(){
    let basicAuthHeaderString=this.createBasicAuthenticationHeader();
    let headers=new HttpHeaders({
        Authrization:basicAuthHeaderString
    })
   return this.httpClient.get<HelloWorldbean>('${API_URL}/hello-worldBean',
   {headers});
  }

  executeHelloWordServiceWithParam(name:string){
    // let basicAuthHeaderString=this.createBasicAuthenticationHeader();
    // let headers=new HttpHeaders({
    //     Authrization:basicAuthHeaderString
    // })

    //console.log("headers are " + basicAuthHeaderString);
    return this.httpClient.get<HelloWorldbean>(`${API_URL}/hello-worldBean/${name}`,
    // {headers}
    );
   }

   createBasicAuthenticationHeader(){
    let username='user'
    let password='dummy'
    let basicAuthString='Basic ' + window.btoa(username + ':' + password)  
    return basicAuthString;
  }
}
