package boot.mvc.thyme;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"myshop.*"}) // 모든 패키지 등록
@MapperScan({"myshop.mapper"}) // mapper 패키지 등록
public class BootMybatisThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMybatisThymeleafApplication.class, args);
	}

}
