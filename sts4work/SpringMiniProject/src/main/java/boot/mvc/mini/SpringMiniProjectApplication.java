package boot.mvc.mini;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.data.*", "boot.mvc.mini"}) // 모든 패키지 등록
@MapperScan("boot.data.mapper") // 매퍼 등록
public class SpringMiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMiniProjectApplication.class, args);
	}

}
