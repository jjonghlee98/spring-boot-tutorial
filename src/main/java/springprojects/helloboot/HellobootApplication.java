package springprojects.helloboot;

import org.springframework.boot.SpringApplication;
import springprojects.config.MySpringBootApplication;


@MySpringBootApplication
public class HellobootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellobootApplication.class, args);
	}

}
