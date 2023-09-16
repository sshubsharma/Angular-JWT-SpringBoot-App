import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardCodedAuthService } from '../service/hard-coded-auth.service';
import { BasicAuthService } from '../service/http/basic-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username='shubham'
  password=''
  errorMessage='invalid credentails'
  inValidCred=false

  constructor(private router:Router,private auth:HardCodedAuthService,
    private basicauth:BasicAuthService){

  }


  ngOnInit(){
    
  }

  handleLogin(){
    //console.log(this.username);
    if(this.auth.authenticate(this.username,this.password)){
      this.router.navigate(['welcome',this.username])
      this.inValidCred=false
    }else{
      this.inValidCred=true
    }
    
  }


  handleBasicAuthLogin(){
    console.log(this.username);
    this.basicauth.executeBasicAuthenticationService(this.username,this.password).
        subscribe(
          data=>{
            this.router.navigate(['welcome',this.username])
            this.inValidCred=false
          },
          error=>{
            this.inValidCred=true
          })   
    }


    handlejwtBasicAuthLogin(){
      console.log(this.username);
      this.basicauth.executejwtAuthenticationService(this.username,this.password).
          subscribe(
            data=>{
              this.router.navigate(['welcome',this.username])
              this.inValidCred=false
            },
            error=>{
              this.inValidCred=true
            })   
      }
    
  }
