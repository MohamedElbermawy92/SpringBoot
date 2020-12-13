package springboot.starter.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import springboot.starter.controller.Todo;
import springboot.starter.errorHandler.ConflictException;
import springboot.starter.errorHandler.NotFounException;
import springboot.starter.repsitory.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository todorepo;
	
	public Todo getTodoById(@PathVariable String id) {
		
		try{
		return todorepo.findById(id).get();
		}catch(NoSuchElementException ex){
			throw new NotFounException(String.format("no record found for id [%s] in database.",id));
		}
	}

	
	public Todo addTodo(Todo t){
		if(todorepo.findByTitle(t.getTitle())== null){
			todorepo.insert(t);
			return t;
		}
		else
			throw new ConflictException("this title already exist in database!!!");
	}
	
	public void removeTodo(@PathVariable String id) {
		
		 todorepo.deleteById(id);

	}
	
	public List<Todo> findAll(){
		return todorepo.findAll();
	}
}
