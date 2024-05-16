package boot.day0516.ex02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.mvc.*"})
public class SpringBootEx02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEx02Application.class, args);
	}

}
