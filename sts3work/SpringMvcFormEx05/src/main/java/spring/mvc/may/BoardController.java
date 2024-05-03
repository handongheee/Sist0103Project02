package spring.mvc.may;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/board")
public class BoardController {
	// form
	@GetMapping ("/form")
	public String form01() {
		return "board/writeForm";
	}
	
	@PostMapping ("/process")
	public ModelAndView process(@RequestParam String name, @RequestParam String date,
			/* required는 true가 기본값, 항목이 없어도 에러가 안나게 하려면 false */
			@RequestParam String gender, @RequestParam(required = false) String msg,
			/* 또는 defaultValue 설정하면 된다. */
			@RequestParam(name="pageNum", defaultValue="1") int currentPage) {
		// 폼에 없는 값을 전송할 때 기본이 true이므로 (required = false) 설정하거나,defaultValue 세팅 
		// => 안해주면 400 error 뜸
		
		ModelAndView model=new ModelAndView();
		
		model.addObject("name", name);
		model.addObject("date", date);
		model.addObject("gender", gender);
		// 값이 넘어오지 않지만 세팅
		model.addObject("msg", msg);
		model.addObject("currentPage", currentPage);
		
		// 포워드
		model.setViewName("board/result");
		
		return model;
	}
	
	// result02
	@GetMapping ("/result02")
	public String result02(Model model) {
		model.addAttribute("myimg01", "../image/03.png");
		model.addAttribute("title", "내가 좋아하는 캐릭터");
		return "/board/result02";
	}
	
	// list 포워드만
	@GetMapping("/list")
	public String list() {
		return "board/list";
	}
	
}
