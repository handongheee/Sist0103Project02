package boot.data.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.AnswerMBoardDto;
import boot.data.service.AnsMBoardService;
import boot.data.service.MemberService;

@RestController
public class AnswerBoardRestController {

	@Autowired
	AnsMBoardService service;
	
	@Autowired
	MemberService mservice;
	
	//insert
	@PostMapping("/board/ainsert")
	public void insert(@ModelAttribute AnswerMBoardDto dto,HttpSession session)
	{
		//글쓴사람 id아니고 로그인한 id
		String myid=(String)session.getAttribute("myid");
		//작성자 이름
		String name=mservice.getName(myid);
		//dto에 넣기
		dto.setMyid(myid);
		dto.setName(name);
		
		//insert
		service.insertAnswer(dto);
	}
	
	//전체출력
	@GetMapping("/board/alist")
	public List<AnswerMBoardDto> alist(String num)
	{
		return service.getAllAnswer(num);
	}
	
	// 0603 수정
	@GetMapping("/board/adata")
	public AnswerMBoardDto adata(String idx) {
		return service.getAnswer(idx);
	}
	
	@PostMapping("/board/aupdate")
	public void aupdate(AnswerMBoardDto dto) {
		service.updateAnswer(dto);
	}
	
	// 0603 삭제
	@GetMapping("/board/adelete")
	public void delete(String idx) {
		service.deleteAnswer(idx);
	}
}
