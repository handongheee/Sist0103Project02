package spring.db.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/member")
public class MemberController {
	
	@Autowired
	MemberDaoInter memInter;
	
	/*
	@GetMapping("list")
	public String list() {
		return "member/memberList";
	}*/
	
	@GetMapping("writeform")
	public String form() {
		return "member/addForm";
	}
	
	@GetMapping("/idcheck")
	@ResponseBody // 브라우저에 json 형식의 결과값 출력
	public Map<String, Integer> idcheck(@RequestParam String id){
		Map<String, Integer> map=new HashMap<String, Integer>();
		int count=memInter.getIdCheck(id);
		
		System.out.println(count);
		map.put("count", count);
		
		return map;
	}
	
	// 목록
	@GetMapping ("/memlist")
	public String list(Model model) {
		List<MemberDto> list=memInter.getAllDatas();
		int count=memInter.getTotalCount();
		
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		
		return "member/memberList";
	}
	
	// 추가
	@PostMapping ("/insert")
	public String insert(@ModelAttribute MemberDto dto) {
		memInter.insertMember(dto);
		return "redirect:memlist";
	}
	
	// 수정
	@GetMapping("/updateform")
	public ModelAndView uform(@RequestParam String num) {
		ModelAndView model=new ModelAndView();
		
		MemberDto dto=memInter.getMember(num);
		
		// dto를 request에 저장
		model.addObject("dto", dto);
		
		// 해당 jsp에 포워드
		model.setViewName("member/updateForm");
		
		return model;
	}
	
	// 비밀번호 체크
	@PostMapping("/update")
	public String update(@ModelAttribute MemberDto dto) {
		// 비밀번호가 일치하는지 체크
		int n=memInter.passCheck(dto.getNum(), dto.getPass()); // 0,1
		
		if(n==1) {
			// 비밀번호가 맞으면 수정 후 목록으로
			memInter.updateMember(dto);
			return "redirect:memlist";
		} else {
			// 틀리면 얼럿창 출력되게
			return "member/passFail";
		}
	}
	
	// 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam String num) {
		memInter.deleteMember(num);
		return "redirect:memlist";
	}
	
}
