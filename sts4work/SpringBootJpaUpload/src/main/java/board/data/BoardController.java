package board.data;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	
	@Autowired  
	BoardDao dao;
	
	// 리스트 랜딩
	@GetMapping("/")
	public String home() {
		return "redirect:board/list";
		
	}
	
	// 리스트
	@GetMapping("/board/list")
	public ModelAndView list() {
		ModelAndView model=new ModelAndView();
		
		List<BoardDto> list=dao.getAllDatas();
		
		// 저장
		model.addObject("list", list);
		model.addObject("count", list.size());
		
		model.setViewName("board/boardList");
		return model;
	}
	
	// 작성폼 랜딩
	@GetMapping("/board/addform")
	public String form() {
		return "board/writeForm";
	}
	
	// 작성
	@PostMapping("/board/add")
	public String insert(@ModelAttribute BoardDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session) {
		
		// 실제 경로
		String realPath=session.getServletContext().getRealPath("/save");
		System.out.println(realPath);
		
		String uploadName=upload.getOriginalFilename();
		
		if(upload.isEmpty()) {
			dto.setPhoto("no"); // 사진이 없는 경우 'no' 삽입
		} else {
			dto.setPhoto(uploadName); // 사진이 있는 경우 파일명 삽입
			
			// 실제 업로드
			try {
				upload.transferTo(new File(realPath+"/"+uploadName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// db 저장
		dao.insertBoard(dto);
		
		return "redirect:list";
	}
	
	// 상세보기 랜딩
	@GetMapping("/board/detail")
	public ModelAndView detail(@RequestParam Long num) {
		ModelAndView mview=new ModelAndView();
		
		BoardDto dto=dao.getData(num);
		mview.addObject("dto", dto);
		
		mview.setViewName("board/detail");
		
		return mview;
	}
	
	// 수정폼 출력
	@GetMapping("/board/updateform")
	public ModelAndView uform(@RequestParam Long num) {
		ModelAndView mview=new ModelAndView();
		
		BoardDto dto=dao.getData(num);
		mview.addObject("dto", dto);
		
		mview.setViewName("board/updateForm");
		
		
		return mview;
	}
	
	
}
