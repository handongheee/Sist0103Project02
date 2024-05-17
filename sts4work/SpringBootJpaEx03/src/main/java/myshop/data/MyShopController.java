package myshop.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyShopController {

	@Autowired
	MyShopDao dao;
	
	@GetMapping("/")
	public String start() {
		return "redirect:shop/list";
	}
	
	@GetMapping("/shop/list")
	public ModelAndView list() {
		ModelAndView mview=new ModelAndView();
		
		List<MyShopDto> list=dao.getAllSangpums();
		
		// 저장
		mview.addObject("list", list);
		mview.addObject("totalCount", list.size());
		
		mview.setViewName("myshop/shopList");
		return mview;
	}
	
	// 입력폼
	@GetMapping("/shop/writeform")
	public String form() {
		return "myshop/addForm";
	}
	
	// insert
	@PostMapping("/shop/insert")
	public String add(@ModelAttribute MyShopDto dto) {
		dao.insertShop(dto);
		return "redirect:list";
	}
	
	// 수정폼
	@GetMapping("/shop/updateform")
	public ModelAndView uform(Long num) {
		ModelAndView model=new ModelAndView();
		
		MyShopDto dto=dao.getData(num);
		
		// 저장
		model.addObject("dto", dto);
		// 포워드
		model.setViewName("myshop/updateForm");
		
		return model;
	}
	
	// 수정
	@PostMapping("/shop/update")
	public String update(@ModelAttribute MyShopDto dto) {
		dao.updateShop(dto);
		return "redirect:list";
	}
	
	// 삭제
	@GetMapping("/shop/delete")
	public String shopdelete(Long num) {
		dao.deleteShop(num);
		return "redirect:list";
	}
}
