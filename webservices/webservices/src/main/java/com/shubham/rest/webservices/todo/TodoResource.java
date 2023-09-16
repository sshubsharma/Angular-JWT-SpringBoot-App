package com.shubham.rest.webservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {
	
	@Autowired
	private HardCodedService hardCodedService;
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return hardCodedService.findAll();
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getAllTodos(@PathVariable String username,@PathVariable Long id){
		return hardCodedService.findById(id);
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable Long id){
		Todo todo=hardCodedService.deleteById(id);
		if(todo!=null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable Long id,@RequestBody Todo todo ){
		Todo updatedTodo=hardCodedService.save(todo);
		return new ResponseEntity<Todo>(todo,HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Todo> saveTodo(@PathVariable String username,@PathVariable Long id,@RequestBody Todo todo ){
		Todo savedTodo=hardCodedService.save(todo);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTodo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}
