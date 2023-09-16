import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL } from 'src/app/app.constants';
import { Todo } from 'src/app/todo-list/todo-list.component';

@Injectable({
  providedIn: 'root'
})
export class TodoDataService {

  constructor(
    private httpClient: HttpClient
  ) { }

  retriveTodoList(username: string){
    return this.httpClient.get<Todo[]>(`${API_URL}/jpa/users/${username}/todos`);
   }

   deleteTodoList(username: string,id: number){
    return this.httpClient.delete(`${API_URL}/jpa/users/${username}/todos/${id}`);
   }

   retriveTodo(username: string,id: number){
    return this.httpClient.get<Todo>(`${API_URL}/jpa/users/${username}/todos/${id}`);
   }

   updateTodo(username: string,id: number,todo: any){
    return this.httpClient.put(`${API_URL}/jpa/users/${username}/todos/${id}`,
                todo);
   }

   saveTodo(username: string,todo: any){
    return this.httpClient.put(`${API_URL}/jpa/users/${username}/todos`,
                todo);
   }

  
}
