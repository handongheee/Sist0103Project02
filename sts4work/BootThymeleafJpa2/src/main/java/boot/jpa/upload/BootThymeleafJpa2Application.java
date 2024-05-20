package boot.jpa.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"mycar.*"})
@EntityScan("mycar.data") // dto 위치
@EnableJpaRepositories("mycar.repository") // dao 위치
public class BootThymeleafJpa2Application {

	public static void main(String[] args) {
		SpringApplication.run(BootThymeleafJpa2Application.class, args);
	}

}
