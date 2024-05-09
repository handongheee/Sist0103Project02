package spring.mvc.json;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		
		
		return "home";
	}
	
	@GetMapping("/jsonex01")
	public String ex1() {
		return "ex01";
	}
	
	@GetMapping("/jsonex02")
	public String ex2() {
		return "ex02";
	}
	
	@GetMapping("/jsonex03")
	public String ex3() {
		return "ex03";
	}
	
	@GetMapping("/jsonex04")
	public String ex4() {
		return "ex04";
	}
	
}
