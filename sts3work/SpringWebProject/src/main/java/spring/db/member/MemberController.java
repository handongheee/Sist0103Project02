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
	
	
}
