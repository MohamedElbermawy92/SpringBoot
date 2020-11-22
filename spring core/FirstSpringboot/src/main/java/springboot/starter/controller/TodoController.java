package springboot.starter.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.starter.service.TodoService;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

	@Autowired
	TodoService todoSer;
	
	@GetMapping("/{id}")
	public ResponseEntity<Todo>  getTodo(@PathVariable String id) {                 
		 todoSer.getTodoById(id);
		return new ResponseEntity<>(todoSer.getTodoById(id),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<Void> delete(@PathVariable String id) {                 
		  todoSer.removeTodo(id);
		  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 
	}
	
	
	// @valid to tell spring to check validation
	//ResponseEntity to return response code
	@PostMapping("/")
	public ResponseEntity<Todo> add(@Valid @RequestBody Todo todo) {                 
		Todo t = todoSer.addTodo(todo); 
		return new ResponseEntity<>(t,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Todo>> findAll() {                 
		return new ResponseEntity<>(todoSer.findAll(),HttpStatus.OK); 
	}

}
