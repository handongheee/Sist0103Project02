package spring.day0502.shop;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

@Controller
public class IndexFormController {
	
	@GetMapping ("/data/myform")
	public String form01() {
		
		return "form01";
	}
	
	// get방식 전송
	@GetMapping ("/data/read01")
	public ModelAndView read01(@RequestParam String name, @RequestParam int age, @RequestParam(value="msg", defaultValue="좋은하루보내세요!") String msg) {
		ModelAndView model=new ModelAndView();
		
		// request에 저장
		model.addObject("name", name);
		model.addObject("age", age);
		// 추가 - 메세지
		model.addObject("msg", msg);
		
		// 포워드
		model.setViewName("getProcess");
		
		return model;	
	}
	
	// post방식 전송 - dto
	@PostMapping ("/data/read02")
	public ModelAndView read02(@ModelAttribute ShopDto dto) {
		// dto와 form에 있는 같은 이름인 것들을 한번에 가져온다!
		ModelAndView model=new ModelAndView();
		model.addObject("dto", dto);
		model.setViewName("postProcess");
		
		return model;
	}
	
	// post방식 전송 - map
	@PostMapping("/data/read03")
	public ModelAndView read03(@RequestParam Map<String, String> map) {
		ModelAndView model=new ModelAndView();
		
		// 저장
		String sang=map.get("sang"); // name값으로 가져옴
		String price=map.get("price");
		String color=map.get("color");
		
		String data=sang+"의 가격은 "+price+"원이며, 색상은 "+color+"입니다.";
		
		model.addObject("data", data);
		// view로 뿌려줄 포워드 주소
		model.setViewName("mapProcess");
		
		return model;
	}
}