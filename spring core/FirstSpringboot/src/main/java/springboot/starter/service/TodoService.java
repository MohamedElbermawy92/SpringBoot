package springboot.starter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import error.handler.NotFounException;
import springboot.starter.controller.Todo;
import springboot.starter.repsitory.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository todorepo;
	
	public Todo getTodoById(@PathVariable String id) {
		
		try{
		return todorepo.findById(id).get();
		}catch(NoSuchElementException ex){
			throw new NotFounException(String.format("no record founf for id [%s] in database.",id));
		}
	}

	
	public Todo addTodo(Todo t){
		//list.add(t);
		
		todorepo.insert(t);
		return t;
	}
	
	public void removeTodo(@PathVariable String id) {
		//System.out.println("id is " + id);
		 todorepo.deleteById(id);

	//	for (Todo t : list) {
	//		if (t.getId() == id)
	//			list.remove(t);
	//		return t;
	//	}
	//	return null;
	}
	
	public List<Todo> findAll(){
		return todorepo.findAll();
	}
}
