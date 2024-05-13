package spring.mvc.re;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.data.BoardDaoInter;
import spring.mvc.data.BoardDto;

@Controller
public class BoardContentController {

	@Autowired
	BoardDaoInter dao;
	
	@GetMapping("/board/content")
	public ModelAndView content(@RequestParam int num, 
			@RequestParam int currentPage) {
		ModelAndView mview=new ModelAndView();
		
		dao.updateReadCount(num); // 조회수
		BoardDto dto=dao.getOneData(num); // 하나의 데이터
		
		// 저장
		mview.addObject("dto", dto); 
		mview.addObject("currentPage", currentPage);
		
		mview.setViewName("board/content"); // 포워드
		
		return mview;
		
	}
	
}
