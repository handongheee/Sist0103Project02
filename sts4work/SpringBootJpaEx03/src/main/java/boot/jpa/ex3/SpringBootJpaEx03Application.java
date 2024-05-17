package boot.jpa.ex3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"*.data"})
@EntityScan("*.data") // dto 인식
@EnableJpaRepositories("*.data") // dao 인식
public class SpringBootJpaEx03Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaEx03Application.class, args);
	}

}
