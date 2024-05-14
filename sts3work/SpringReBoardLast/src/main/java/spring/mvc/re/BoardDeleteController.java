package spring.mvc.re;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.data.BoardDaoInter;
import spring.mvc.data.BoardDto;

@Controller
public class BoardDeleteController {
	@Autowired
	BoardDaoInter dao;

	@GetMapping("/board/deletepassform")
	public ModelAndView upassform(@RequestParam String num, @RequestParam String currentPage) {
		ModelAndView mview = new ModelAndView();
		mview.addObject("num", num);
		mview.addObject("currentPage", currentPage);

		mview.setViewName("board/deletePassForm");

		return mview;
	}
	
	@PostMapping("/board/delete")
	public String delete(@RequestParam int num, @RequestParam int pass, @RequestParam String currentPage,
			HttpSession session) {
		
		// 비밀번호가 맞으면 수정폼으로 포워드, 틀리면 passfail로 포워드
		int check=dao.getCheckPass(num, pass);
		
		if(check==0) {
			return "board/passFail";
		} else {
			// 파일 삭제
			String photo=dao.getOneData(num).getPhoto();
			
			if(!photo.equals("no")) {
				// 컴마 분리하여 배열에 저장
				String [] fName=photo.split(",");
				
				String path=session.getServletContext().getRealPath("/WEB-INF/photo");
				
				for(String f:fName) {
					// 파일 생성 후 파일 삭제
					File file=new File(path+"/"+f);
					file.delete();
				}
			}
			
			// db 삭제
			dao.deleteBoard(num);
			
			return "redirect:list?currentPage="+currentPage;
		}	

	}
	
}
