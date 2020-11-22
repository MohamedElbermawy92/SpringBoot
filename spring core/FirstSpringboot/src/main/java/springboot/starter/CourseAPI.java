package springboot.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//this annotation to tell that this class is springboot this is stating point for spring
@SpringBootApplication
public class CourseAPI {

	public static void main(String[] args) {
		// to create servlet container
		SpringApplication.run(CourseAPI.class, args);
	}

}
