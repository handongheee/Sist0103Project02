package spring.db.carmember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/carmember")
public class CarMemberController {
	@Autowired
	CarMemberDaoInter memInter;
	
	@GetMapping ("/writeForm")
	public String memForm() {
		
		return "car/memberForm";
	}
	
}
