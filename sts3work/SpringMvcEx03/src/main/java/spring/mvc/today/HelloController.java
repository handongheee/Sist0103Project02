package spring.mvc.today;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 빈에 등록하는 행위
public class HelloController {
	
	//@RequestMapping (value="/", method = RequestMethod.GET) ==> 한줄로 생략 가능
	/*@GetMapping ("/")
	public String hello01(Model model) {
		model.addAttribute("name", "한동희"); //한동희를 name으로 저장
		model.addAttribute("addr", "서울시 강남구 역삼동");
		
		return "result01";
		
	}*/
}
