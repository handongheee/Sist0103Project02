package spring.db.may;

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
@RequestMapping ("/samsung")
public class CarController {
	
	@Autowired // 자동주입
	SpringCarDaoInter carInter;
	
	@GetMapping ("/list")
	private String list(Model model) {
		// dao로부터 총개수 저장
		int totalCount=carInter.getTotalCount();
		// 목록 가져오기
		List<SpringCarDto> list=carInter.getAllCarDatas();
		
		// request에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "car/carList";
	}
	
	@GetMapping ("/writeForm")
	public String carForm() {
		return "car/addForm";
	}
	
	@PostMapping ("/write")
	public String insert(@ModelAttribute("dto") SpringCarDto dto) {
		
		// insert 메서드 가져옴
		carInter.insertCar(dto); 
		
		return "redirect:list"; // 위에 이미 있으므로 redirect
	}
	
	@GetMapping ("/updateForm")
	public String uform(@RequestParam String num, Model model) {
		SpringCarDto dto=carInter.getData(num);
		model.addAttribute("dto", dto);
		return "car/updateForm";
	}
	
	@PostMapping ("/update")
	public String update(@ModelAttribute SpringCarDto dto) {
		carInter.updateCar(dto);
		return "redirect:list";
	}
	
	@GetMapping ("/delete")
	public String delete(@RequestParam String num) {
		carInter.deleteCar(num);
		return "redirect:list";
	}
	
}
