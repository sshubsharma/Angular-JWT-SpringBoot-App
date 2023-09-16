import { Injectable } from '@angular/core';
import { CanActivate,ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { HardCodedAuthService } from '../service/hard-coded-auth.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate{

  constructor(private router: Router,private auth:HardCodedAuthService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(this.auth.isUserLogedIn())
    return true;
    this.router.navigate(['login']);
    return false;
  }

  
}
