package spring.mvc.may;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/shop")
public class ShopController {
	
	@GetMapping ("/dtoForm")
	public String dtoform() {
		return "shop/formDto";
	}
	
	@GetMapping ("/mapForm")
	public String mapform() {
		return "shop/formMap";
	}
	
	// dto 처리 @ModelAttribute => 저장 안하고 dto 읽기
	@PostMapping ("/process01")
	public String process01(@ModelAttribute ShopDto dto) {		
		return "shop/dtoResult";
	}
	
	
	// map 처리
	@PostMapping("/process02")
	public ModelAndView process02(@RequestParam Map<String, String> map) {
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("sang", map.get("sang"));
		mview.addObject("su", map.get("su"));
		mview.addObject("price", map.get("price"));
		mview.addObject("color", map.get("color"));
		
		// 어디서 보여질지?
		mview.setViewName("shop/mapResult");
		
		return mview;
	}

}
