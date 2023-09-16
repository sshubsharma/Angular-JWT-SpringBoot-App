package com.shubham.rest.webservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HardCodedService {
	
	private static List<Todo> todos=new ArrayList<>();
	private static long counter=0;
	
	static {
		todos.add(new Todo(++counter,"shubham","learning Java along with Angular",new Date(),false));
		todos.add(new Todo(++counter,"mogli","learning to dance",new Date(),false));
		todos.add(new Todo(++counter,"Hari","learning microservices",new Date(),false));
		todos.add(new Todo(++counter,"Narayan","learning css",new Date(),false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo deleteById(Long id) {
		Todo todo=findById(id);
		if(todo==null) return null;
		if(todos.remove(todo)) {
			return todo;
		}
		return null;
		
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++counter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
			
		}
		
		return todo;
	}
	
	public Todo findById(Long id) {
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
			
		}
		return null;
	}

}
