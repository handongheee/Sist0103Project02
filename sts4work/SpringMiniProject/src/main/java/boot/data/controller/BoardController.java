package boot.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@GetMapping("/board/list")
	public ModelAndView list() {
		ModelAndView mview=new ModelAndView();
		
		mview.setViewName("/sub/board/boardList");
		
		return mview;
	}
}
