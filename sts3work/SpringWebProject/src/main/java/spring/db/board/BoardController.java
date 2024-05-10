package spring.db.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardDaoInter dao;

	@GetMapping("/list")
	public ModelAndView List(@RequestParam(value="currentPage", defaultValue="1")int currentPage) {
		ModelAndView mview=new ModelAndView();
		// * 페이지 ----------------------------------------------------------------------
		// 총 개수 구하기
		int totalCount=dao.getTotalCount();
		int perPage=5; // 한페이지당 보여질 글의 개수
		int perBlock=5; // 한블럭당 보여질 페이지 개수
		int start; // db에서 가져올 글의 시작 번호(mysql은 첫글이 0번, oracle은 1번)
		int startPage; // 각 블럭마다 보여질 시작페이지
		int endPage; // 각 블럭마다 보여질 끝페이지
		int totalPage; // 총 페이지 수.
		int no; // 각 페이지당 출력할 시작번호 (필수 아님)
		
		// 총 페이지 수 구한다
		// (총 글 개수)/(한페이지당 보여질 개수)로 나눔 (7/5=1)
		// 나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지 추가)
		totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
		
		// 각 블럭 당 보여질 시작페이지
		// perBlock=5일 경우 현재 페이지가 1~5일 경우 시작페이지가 1, 끝페이지는 5
		// 현재가 13페이지일 경우엔 시작이 11 끝은 15
		startPage=(currentPage-1)/perBlock*perBlock+1;
		endPage=startPage+perBlock-1;
		
		// 총 페이지가 23일 경우 마지막 블럭은 25가 아닌 23
		if(endPage>totalPage){
			endPage=totalPage;
		}
		
		// 각 페이지에서 보여질 시작번호
		// 1페이지:0, 2페이지:5, 3페이지:10...
		start=(currentPage-1)*perPage;
		
		// 각 페이지당 출력할 시작 번호 구하기
		// ex. 총 글 개수가 23, 1페이지는:23 2페이지는:18, 3페이지는:13..
		no=totalCount-(currentPage-1)*perPage;
		
		// 페이지에서 보여질 글만 가져오기
		//List<SimpleBoardDto> list=dao.getPagingList(startNum, perPage);
		// --------------------------------------------------------------------------
		
		// 리스트
		//List<BoardDto> list=dao.getAllList();
		List<BoardDto> list=dao.getList(start, perPage);
		
		// request 저장
		mview.addObject("totalCount", totalCount);
		mview.addObject("list", list);
		mview.addObject("no", no);
		mview.addObject("startPage", startPage);
		mview.addObject("endPage", endPage);
		mview.addObject("currentPage", currentPage);
		mview.addObject("totalPage", totalPage);
		
		// 포워드
		mview.setViewName("board/boardList");
		
		return mview;
	}
	
	// 글쓰기 폼
	@GetMapping("/addform")
	public String addform() {
		return "board/writeForm";
	}
	
	// insert
	@PostMapping("/insert")
	public String insert(@ModelAttribute BoardDto dto, 
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session, 
			@RequestParam String currentPage) {
		
		// 이미지가 업로드될 폴더
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(path);
		
		// 이미지 업로드 안할 경우 "no" or null로 저장
		String photo="";
		
		// 사진 선택을 하면 ','로 나열
		if(upload.get(0).getOriginalFilename().equals("")) {
			photo="no"; //photo=null;
		} else {
			for(MultipartFile f:upload) {
				String fname=f.getOriginalFilename();
				photo+=fname+",";
				
				// 실제 업로드
				try {
					f.transferTo(new File(path+"/"+fname));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// photo에서 마지막 컴마 제거 후 photo에 적용
			photo=photo.substring(0, photo.length()-1);	
		}
		
		// dto의 photo에 넣어주기
		dto.setPhoto(photo);
		
		// insert 호출
		dao.insertBoard(dto);
		
		// 목록이 아닌 상세보기로 가려면
		int num=dao.getMaxNum();
		
		return "redirect:content?num="+num+"&currentPage="+1;
	}
	
	// 상세보기로 가기
	@GetMapping("/content")
	public String content(@RequestParam int num, Model model, 
			@RequestParam String currentPage) {
		dao.updateReadcount(num);
		
		// dto 가져와서
		BoardDto dto=dao.getData(num);
		
		// request에 저장
		model.addAttribute("dto", dto);
		model.addAttribute("currentPage", currentPage);
		
		return "board/content";
	}
	
	
}
