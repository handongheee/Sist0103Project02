package boot.mvc.quiz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.*"})
@MapperScan({"boot.*"})
public class SpringBootMybatisQApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisQApplication.class, args);
	}

}
