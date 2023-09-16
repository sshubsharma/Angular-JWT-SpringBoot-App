import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardCodedAuthService {

  constructor() { 

  }

  authenticate(username: string ,password: string){
    if(username==="shubham" && password==='dummy'){
      sessionStorage.setItem('authUser',username);
      return true;
    }
      return false;
  }

  isUserLogedIn(){
    let user=sessionStorage.getItem('authUser');
    return !(user===null)
  }

  logout(){
    sessionStorage.removeItem('authUser');
  }
}
