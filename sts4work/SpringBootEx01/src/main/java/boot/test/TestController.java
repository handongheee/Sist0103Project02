package boot.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.ex01.TestDto;

@RestController
public class TestController {

	@GetMapping("/test")
	public TestDto hello() {
		TestDto dto=new TestDto();
		dto.setName("한동희");
		dto.setAddr("서울 강남구 역삼동");
		
		return dto;
	}
}
