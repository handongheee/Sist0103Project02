package spring.mvc.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {
	
	@GetMapping ("/info/myform")
	public String form() {
		return "infoForm";
	}
	
	@PostMapping ("/info/result")
	public String write(@ModelAttribute InfoDto dto) {
		return "infoWrite";
	}

}
