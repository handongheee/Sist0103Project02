package boot.mvc.market;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"data.*"}) // controller
@MapperScan({"data.mapper"}) // mapper 등록하는 곳
public class BootMybatisJstlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMybatisJstlApplication.class, args);
	}

}
