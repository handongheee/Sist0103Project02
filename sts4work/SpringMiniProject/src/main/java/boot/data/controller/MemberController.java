package boot.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	@GetMapping("member/list")	
	public ModelAndView list() {
		ModelAndView mview=new ModelAndView();
		
		mview.setViewName("/member/memberList");
		
		return mview;
	}
	
	@GetMapping("member/form")
	public String form() {
		return "/member/memberForm";
	}
	
}
