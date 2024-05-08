package spring.mysql.coffee;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	MyshopDaoInter daoInter;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		// Model model : 저장할 인터페이스
		
		List<MyshopDao> list=daoInter.getAllList();
		
		model.addAttribute("list", list);
		model.addAttribute("totalCount", list.size());
		
		// 포워드
		return "home";
	}
	
}
