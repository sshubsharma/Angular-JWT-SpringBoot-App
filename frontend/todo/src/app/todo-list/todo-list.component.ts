import { Component } from '@angular/core';
import {  OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Route, Router } from '@angular/router';

export class Todo{

  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public targetDate: Date
   

  ){

  }
}

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit{

  // todos=[
  //   new Todo(1,'learning angular',false,new Date()),
  //   new Todo(2,'learning angular',false,new Date()),
  //   new Todo(3,'learning angular',false,new Date()),
  //   new Todo(4,'learning angular',false,new Date())
   


  // ]

  

  // todo={
  //   id:1,
  //   description:'learning angular'

  // }
  todos: Todo[] =[];

  message: string='';
  
  constructor(private todoService:TodoDataService,private route:Router){
    this.refreshListTodos()
    
  }

  ngOnInit(){
    this.refreshListTodos()
  }
  refreshListTodos(){
    this.todoService.retriveTodoList('shubham').subscribe(
      response=>{
        this.todos=response;
      }
    )
  }


  deleteTodo(id:number){
    this.todoService.deleteTodoList('shubham',id).subscribe(
      response=>{
        console.log("yha tak a rha hia");
        this.message=`Delete of ${id} Successful!`
        console.log("yha tak a rha hia");
        this.refreshListTodos()
      }
    )
  }

  updateTodo(id:number){
    this.route.navigate(['todos',id])
  }

  addNewTodo(){
    this.route.navigate(['todos',-1])
  }


}
