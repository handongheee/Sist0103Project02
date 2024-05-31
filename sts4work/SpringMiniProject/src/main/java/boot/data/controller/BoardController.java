package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MemBoardDto;
import boot.data.service.MemBoardService;
import boot.data.service.MemberService;

@Controller
public class BoardController {
	
	@Autowired
	MemBoardService service;
	
	@Autowired
	MemberService mservice;

	@GetMapping("/board/list")
	public ModelAndView list(@RequestParam(value="currentPage", defaultValue="1")int currentPage) {
		ModelAndView mview=new ModelAndView();
		
		int totalCount=service.getTotalCount();
			
		// * 페이지 ----------------------------------------------------------------------
		// 총 개수 구하기
		//int totalCount = dao.getTotalCount();
		int perPage = 5; // 한페이지당 보여질 글의 개수
		int perBlock = 5; // 한블럭당 보여질 페이지 개수
		int start; // db에서 가져올 글의 시작 번호(mysql은 첫글이 0번, oracle은 1번)
		int startPage; // 각 블럭마다 보여질 시작페이지
		int endPage; // 각 블럭마다 보여질 끝페이지
		int totalPage; // 총 페이지 수.
		int no; // 각 페이지당 출력할 시작번호 (필수 아님)

		// 총 페이지 수 구한다
		// (총 글 개수)/(한페이지당 보여질 개수)로 나눔 (7/5=1)
		// 나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지 추가)
		totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);

		// 각 블럭 당 보여질 시작페이지
		// perBlock=5일 경우 현재 페이지가 1~5일 경우 시작페이지가 1, 끝페이지는 5
		// 현재가 13페이지일 경우엔 시작이 11 끝은 15
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;

		// 총 페이지가 23일 경우 마지막 블럭은 25가 아닌 23
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// 각 페이지에서 보여질 시작번호
		// 1페이지:0, 2페이지:5, 3페이지:10...
		start = (currentPage - 1) * perPage;

		// 각 페이지당 출력할 시작 번호 구하기
		// ex. 총 글 개수가 23, 1페이지는:23 2페이지는:18, 3페이지는:13..
		no = totalCount - (currentPage - 1) * perPage;
		
		// 리스트
		List<MemBoardDto> list = service.getList(start, perPage);

		// request 저장
		mview.addObject("totalCount", totalCount);
		mview.addObject("list", list);
		mview.addObject("no", no);
		mview.addObject("startPage", startPage);
		mview.addObject("endPage", endPage);
		mview.addObject("currentPage", currentPage);
		mview.addObject("totalPage", totalPage);
		// --------------------------------------------------------------------------

		
		mview.setViewName("/sub/board/boardList");
		
		return mview;
	}
	
	@GetMapping("/board/form")
	public String form() {
		return "/board/writeForm";
	}
	
	@PostMapping("/board/insert")
	public String insert(@ModelAttribute MemBoardDto dto, HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/boardphoto");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		if(dto.getUpload().getOriginalFilename().equals("")) {
			dto.setUploadfile("no");
		} else {
			// 업로드 할 경우
			String uploadfile=sdf.format(new Date())+dto.getUpload().getOriginalFilename();
			dto.setUploadfile(uploadfile);
			
			// 
			try {
				dto.getUpload().transferTo(new File(path+"/"+uploadfile));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 세션에서 아이디 얻어서 dto 저장
		String myid=(String)session.getAttribute("myid");
		dto.setMyid(myid);
		
		// 이름
		String name=mservice.getName(myid);
		dto.setName(name);
		
		// insert
		service.insertMemBoard(dto);
		
		return "redirect:list";
	}
	
	// content로 이동 - 조회수,num에 따른 dto넘기기
	@GetMapping("/board/content")
	public ModelAndView content(String num, @RequestParam(defaultValue = "1") int currentPage) {
		ModelAndView mview=new ModelAndView();
		
		// 조회수 증가
		service.updateReadCount(num);
		MemBoardDto dto=service.getData(num);
		
		// 업로드 파일의 확장자 얻기
		int dtoLoc=dto.getUploadfile().lastIndexOf('.'); // 파일의 마지막 점 위치
		String ext=dto.getUploadfile().substring(dtoLoc+1); // dtoLoc의 다음글자부터 끝까지
		
		System.out.println(dtoLoc+","+ext);
		
		// 이미지인지 아닌지 보고 출력하기 위해서
		if(ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("gif") || ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("jpeg")) {
			mview.addObject("bupload", true);
		} else {
			mview.addObject("bupload", false);
		}
		
		
		mview.addObject("dto", dto);
		mview.addObject("currentPage", currentPage);
		
		// 포워드
		mview.setViewName("/board/content");
		
		return mview;
	}
	
	
}
