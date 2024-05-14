package spring.mvc.re;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.data.BoardDaoInter;
import spring.mvc.data.BoardDto;

@Controller
public class BoardUpdateController {
	
	@Autowired
	BoardDaoInter dao;
	
	@GetMapping("/board/updatepassform")
	public ModelAndView upassform(@RequestParam String num, @RequestParam String currentPage) {
		ModelAndView mview=new ModelAndView();
		mview.addObject("num", num);
		mview.addObject("currentPage", currentPage);
		
		mview.setViewName("board/updatePassForm");
		
		return mview;
	}
	
	@PostMapping("/board/updatepass")
	public ModelAndView updatepass(@RequestParam int num, @RequestParam int pass, @RequestParam int currentPage) {
		ModelAndView mview=new ModelAndView();
		
		// 비밀번호가 맞으면 수정폼으로 포워드, 틀리면 passfail로 포워드
		int check=dao.getCheckPass(num, pass);
		
		if(check==1) {
			//dto 얻기(수정폼으로 가기 위해)
			BoardDto dto=dao.getOneData(num);
			
			mview.addObject("dto", dto);
			mview.addObject("currentPage", currentPage);
			
			mview.setViewName("board/updateForm");
		} else {
			mview.setViewName("board/passFail");
		}
		
		return mview;
	}
	
	@PostMapping("/board/update")
	public String insert(@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session, 
			@RequestParam String currentPage) {
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(path);
		
		String photo="";
		if(upload.get(0).getOriginalFilename().equals("")) { 
			photo=null; // sql에서 조건을 null이라고 설정(mapper)
		} else {
			for(MultipartFile f:upload) {
				String fName=sdf.format(new Date())+f.getOriginalFilename();
				photo+=fName+",";
				
				// 실제 업로드
				try {
					f.transferTo(new File(path+"/"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// for문 빠져나와서 마지막 컴마 제거
			photo=photo.substring(0, photo.length()-1);
		}
		
		dto.setPhoto(photo); // dto의 photo에 넣어주기
		dao.updateBoard(dto); // 수정메서드
		
		return "redirect:content?num="+dto.getNum()+"&currentPage="+currentPage;
	}
	
}
