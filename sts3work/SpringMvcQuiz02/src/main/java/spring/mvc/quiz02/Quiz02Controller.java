package spring.mvc.quiz02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Quiz02Controller {

	// 처음 실행때 testForm으로 연결되게 "/" 맵핑
	@GetMapping ("/")
	public String sawonForm() {
		return "testForm";
	}
	
	@PostMapping ("/info")
	public ModelAndView readInfo(@ModelAttribute SawonDto dto) {
		ModelAndView model=new ModelAndView();
		
		// dto 저장
		model.addObject("dto", dto);
		// 결과값이 출력될 곳 
		model.setViewName("sawonInfo"); 
		
		return model;
		
	}
}
