package spring.mvc.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {
	
	// 3개의 매핑주소를 포워드한 주소로 연결되게 만들고 결과물은 해당 포워드된 jsp 파일에서 나타나게 한다.
	@GetMapping ("/happy")
	public String happy() {
		return "nice"; // WEB-INF/data/nice.jsp
	}
	
	@GetMapping ("/hello")
	public String hello(Model model) {
		model.addAttribute("msg", "2번문제_안녕하세요.");

		return "hello";
	}
	
	@GetMapping ("/nice/like")
	public String nice(Model model) {
		model.addAttribute("name", "한동희");
		model.addAttribute("hp", "010-1212-1212");
		model.addAttribute("addr", "서울 강남구 역삼동");
		
		return "happy";
	}


}
