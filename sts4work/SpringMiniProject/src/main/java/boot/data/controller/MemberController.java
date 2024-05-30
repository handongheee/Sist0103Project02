package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;


@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("member/list")	
	public ModelAndView list() {
		ModelAndView mview=new ModelAndView();
		
		List<MemberDto> list=service.getAllMembers();
		
		// 저장
		mview.addObject("list", list);
		mview.addObject("mcount", list.size());
		
		// 포워드
		mview.setViewName("/member/memberList");
		
		return mview;
	}
	
	@GetMapping("member/form")
	public String form() {
		return "/member/memberForm";
	}
	
	// id 중복체크
	@GetMapping("/member/idcheck")
	@ResponseBody
	public Map<String, Integer> idcheckprocess(@RequestParam String id){
		Map<String, Integer> map=new HashMap<>();
		
		// id체크 메서드 호출
		int n=service.getSearchId(id);
		
		// 저장
		map.put("count", n); // 1 or 0
		
		return map;
	}
	
	// insert
	@PostMapping("/member/insert")
	public String insert(@ModelAttribute MemberDto dto, MultipartFile myphoto,
			HttpSession session) {
		// 톰캣에 올라간 업로드 폴더 경로 구하기
		String path=session.getServletContext().getRealPath("/memberphoto");
		
		// 저장할 파일명 구하기
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName=sdf.format(new Date())+"_"+myphoto.getOriginalFilename();
		
		// dto에 넣기
		dto.setPhoto(fileName);
		
		// 업로드
		try {
			myphoto.transferTo(new File(path+"/"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// db 추가
		service.insertMember(dto);
		
		return "redirect:list";
	}
	
	// 회원정보로 가기
	@GetMapping("/member/myinfo")
	public String myinfo(Model model) {
		
		List<MemberDto> list=service.getAllMembers();
		model.addAttribute("list", list);
		
		return "/member/memberInfo";
	}
	
	// 회원 목록 삭제
	@GetMapping("/member/delete")
	@ResponseBody
	public void deleteMember(String num) {
		service.deleteMember(num);
	}
	
	// 이미지 수정 MultipartFile photo -> form name이 없을땐 db명으로
	@PostMapping("/member/updatephoto")
	@ResponseBody // ajax, json
	public void photoUpload(String num, MultipartFile photo, HttpSession session) {
		String path=session.getServletContext().getRealPath("/memberphoto");
		
		// 파일명 구하기
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName=sdf.format(new Date())+photo.getOriginalFilename();
		
		// 업로드
		try {
			photo.transferTo(new File(path+"/"+fileName));
			
			// db 사진 수정
			service.updatePhoto(num, fileName);
			
			// 0530 추가 
			session.setAttribute("loginphoto", fileName); // 사진 수정 시 fileName을 세션의 loginphoto로 변경
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 수정폼에 출력할 데이터 반환
	@GetMapping("/member/updateform")
	@ResponseBody
	public MemberDto getData(String num) {
		return service.getDataByNum(num); // num에 따른 dto값 반환
	}
	
	// 수정
	@PostMapping("/member/update")
	@ResponseBody
	public void update(MemberDto dto) {
		service.updateMember(dto);
	}
	
	// 탈퇴
	@GetMapping("/member/deleteme")
	@ResponseBody
	public void deleteme(String num, HttpSession session) {
		service.deleteMember(num);
		
		// 세션 삭제
		session.removeAttribute("loginok");
		session.removeAttribute("myid");
	}
	
}
