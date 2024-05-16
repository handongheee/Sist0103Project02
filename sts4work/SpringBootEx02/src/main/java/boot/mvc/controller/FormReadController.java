package boot.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.data.InfoDto;

@Controller
public class FormReadController {

	@PostMapping("sist/read1")
	public ModelAndView result1(@RequestParam String name, @RequestParam int java, 
			@RequestParam int spring) {
		ModelAndView mview=new ModelAndView();
		
		int total=java+spring;
		int avg=total/2;
		
		// request에 저장
		mview.addObject("name", name);
		mview.addObject("java", java);
		mview.addObject("spring", spring);
		mview.addObject("total", total);
		mview.addObject("avg", avg);
		
		// 포워드
		mview.setViewName("result/result1");
		
		return mview;
	}
	
	@PostMapping("sist/show2")
	public String result2(@ModelAttribute InfoDto dto) {
		return "result/result2";
	}
	
	@PostMapping("/sist/write3")
	// map으로 읽을 경우 폼의 name이 키값, 입력값이 value 값으로 저장
	public ModelAndView result3(@RequestParam Map<String, String> map) {
		ModelAndView model=new ModelAndView();
		
		model.addObject("name", map.get("name"));
		model.addObject("blood", map.get("blood"));
		model.addObject("buseo", map.get("buseo"));
		
		model.setViewName("result/result3");
		
		return model;
	}
}
