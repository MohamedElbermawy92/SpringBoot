package com.test.todoTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import springboot.starter.controller.Todo;
import springboot.starter.repsitory.TodoRepository;
import springboot.starter.service.TodoService;

@RunWith(SpringRunner.class)
public class TodoTest {

	
	// @MocBean to create virtual environment
	@MockBean
	private TodoRepository todoRepo;
	
	@Autowired
	private TodoService todoSer;
	
	@TestConfiguration
	static class TodoServiceContextConiguration{
		
		@Bean
		TodoService getTodo(){
			return new TodoService();
		}
	}
	
	@Test
	public void findAllTest(){
		
		Todo todo1 = new Todo("1", "todo test1", "test 1");
		Todo todo2 = new Todo("2", "todo test2", "test 2");

		List<Todo> list = Arrays.asList(todo1,todo2);
		
		BDDMockito.given(todoRepo.findAll()).willReturn(list);
		assertThat(todoSer.findAll()).hasSize(2).contains(todo1,todo2);
	}
	
	@Test
	public void getById_shouldReturnTodo(){
		
		Todo todo1 = new Todo("1", "todo test1", "test 1");
		BDDMockito.given(todoRepo.findById(BDDMockito.anyString())).willReturn(Optional.ofNullable(todo1));
		
		Todo result = todoSer.getTodoById("1");
		System.out.println(result.getDescription());

		System.out.println(result.getDescription().equals("sss")?"result is true>>>>>":"result is false>>>");
		assertThat(result.getTitle()).containsIgnoringCase("todo");

	}
	
	@Test(expected = Exception.class)
	public void whenInvaildId_todoShouldBeNotFound(){
   
		BDDMockito.given(todoRepo.findById(BDDMockito.anyString())).willReturn(Optional.empty());

		 todoSer.getTodoById("1");
	}
}
