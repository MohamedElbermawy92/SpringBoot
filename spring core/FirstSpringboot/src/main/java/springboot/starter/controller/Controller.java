package springboot.starter.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// this annotation to tell that this class is controller
@RestController
public class Controller {

	// this annotation to map this method and request
	@RequestMapping("/hello")
	public String say(){
		
		return"Hello";
	}
	
	@RequestMapping("/{name}")
	// @pathvariable to annotated that this parameter (name) will be passed in request (url)
	public String sayWithName(@PathVariable String name){
		
		return String.format("welcome %s to spring boot", name);
	}
	
}
