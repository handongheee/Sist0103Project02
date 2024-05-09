package spring.db.carmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/carmember")
public class CarMemberController {
	@Autowired
	CarMemberDaoInter dao;
	
	@GetMapping ("/list")
	public String list(Model model) {
		// 목록 가져오기
		List<CarMemberDto> list=dao.getAllDatas();
		
		int count=dao.getTotalCount();
		
		// request 목록에 저장
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		
		return "carmember/memberList";
	}
	
	@GetMapping ("/writeform")
	public String form() {
		return "carmember/memberForm";
	}
	
	@PostMapping("/write")
	public String insert(@ModelAttribute CarMemberDto dto) {
		dao.insertMember(dto);
		return "redirect:list";
	}
	
	@GetMapping ("/updateForm")
	public String uform(@RequestParam String num, Model model) {
		CarMemberDto dto=dao.getOneData(num);
		
		// 저장
		model.addAttribute("dto", dto);
		
		return "carmember/updateForm";
	}
	
	@PostMapping ("/update")
	public String update(@ModelAttribute CarMemberDto dto) {
		dao.updateCarMember(dto);
		return "redirect:list";
	}
	
	@GetMapping ("/delete")
	public String delete(@RequestParam String num) {
		dao.deleteMember(num);
		return "redirect:list";
	}
	
	
}
