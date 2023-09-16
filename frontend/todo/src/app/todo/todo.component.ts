import { Component, OnInit} from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Todo } from '../todo-list/todo-list.component';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent  implements OnInit {
  id:number
  todo :Todo

  constructor(private todoService:TodoDataService,private router:ActivatedRoute
        ,private rout:Router){

  }

  ngOnInit()  {
    this.id=this.router.snapshot.params['id']
    this.todo=new Todo(this.id,'',false,new Date());
    if(this.id!=-1){
      this.todoService.retriveTodo('shubham',this.id).subscribe(
        response => this.todo =response   
      )
      
    }
    
  }

  saveTodo(){
    if(this.id===-1){
      this.todoService.saveTodo('shubham',this.todo).
      subscribe(
        data=>{
          //console.log(data);
          this.rout.navigate(['todos'])
        }

      )
    }else{
      this.todoService.updateTodo('shubham',this.id,this.todo).
        subscribe(
          data=>{
            //console.log(data);
            this.rout.navigate(['todos'])
          }

        )
    }   
  }
}
