package data.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.dto.ShopDto;
import jakarta.servlet.http.HttpSession;

@Controller
public class HelloThController {

	List<ShopDto> list=new ArrayList<>();
	
	@GetMapping("/")
	public String home() {
		return "home"; // = templates/home.html
	}
	
	@GetMapping("/hello1")
	public String hello1(Model model) {
		System.out.println("hello1 controller");
		
		model.addAttribute("message", "Have a Nice Day! 😆");
		model.addAttribute("today", new Date());
		
		ShopDto dto=ShopDto.builder()
				.num(100)
				.sangpum("신발")
				.su(14)
				.dan(135000)
				.color("blue")
				.build(); // .build() 값 생성
		
		model.addAttribute("dto", dto);
		
		return "hello01"; // templates/hello01.html
	}
	
	@GetMapping("/hello2")
	public String hello2(String name, int age, Model model)
	{
		model.addAttribute("hello2_msg", name+"님의 나이는 "+age+"세 입니다");
		return "hello02";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		list.add(new ShopDto(1, "시계", 5, 12000000, "silver"));
		list.add(new ShopDto(2, "가방", 3, 9000000, "black"));
		list.add(new ShopDto(3, "티셔츠", 25, 195000, "gray"));
		list.add(new ShopDto(4, "안경", 30, 320000, "black"));
		
		ShopDto dto5=ShopDto.builder()
				.num(5)
				.sangpum("텀블러")
				.su(8)
				.dan(30000)
				.color("white")
				.build();
		
		list.add(dto5);
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam int index, Model model) {
		model.addAttribute("dto", list.get(index));
		
		return "detail";
	}
	
	@GetMapping("login1")
	public String login1(HttpSession session) {
		session.setAttribute("myid", "admin");
		return "login";
	}
	
	@GetMapping("login2")
	public String login2(HttpSession session) {
		session.setAttribute("myid", "han");
		return "login";
	}
}
