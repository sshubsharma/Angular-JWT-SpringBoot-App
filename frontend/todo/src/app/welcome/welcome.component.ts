import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { ActivatedRoute } from '@angular/router';
import { HelloWorldbean, WelcomeDataService } from '../service/data/welcome-data.service';


@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
message :  string='help this is starting';
responseMsgFromApi: string='';
responseErrorMsgFromApi : string='';
name=''

//active route
constructor(private router:ActivatedRoute,
            private welcomeDataService:WelcomeDataService){

}

ngOnInit(): void {
  //console.log(this.message);
  this.name=this.router.snapshot.params['name'];
  }

  // getWelcomeMsg(){
  //  console.log(this.welcomeDataService.executeHelloWordService());
  //  this.welcomeDataService.executeHelloWordService().subscribe(
  //   response=>this.handleSuccessResponse(response),
  //   error=>this.handleErrorResponse(error)

  //  );

  // }

  getWelcomeMsgWithParam(){
    //console.log(this.welcomeDataService.executeHelloWordServiceWithParam(this.name));
    this.welcomeDataService.executeHelloWordServiceWithParam(this.name).subscribe(
     response=>this.handleSuccessResponse(response),
     error=>this.handleErrorResponse(error)
 
    );
    
 
   }

  handleSuccessResponse(response:HelloWorldbean){
    this.responseMsgFromApi=response.message;

  }

  handleErrorResponse(error:HelloWorldbean){
    this.responseErrorMsgFromApi=error.message;

  }

  
}
