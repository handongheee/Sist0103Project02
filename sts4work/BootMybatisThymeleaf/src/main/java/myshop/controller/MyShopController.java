package myshop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import myshop.dto.ShopDto;
import myshop.service.MyShopService;

@Controller
@RequiredArgsConstructor // final만 가능
public class MyShopController {

	private final MyShopService shopService;
	
	@GetMapping("/")
	public String list(Model model) {
		int totalCount=shopService.getTotalCount();
		List<ShopDto> list=shopService.getAllSangpums();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "myshop/shopList";
	}
	
	@GetMapping("/addform")
	public String form() {
		return "myshop/shopForm";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute ShopDto dto, @RequestParam MultipartFile upload, HttpSession session) {
		
		String realPath=session.getServletContext().getRealPath("/photo");
		
		String photoname=upload.getOriginalFilename();
		dto.setPhoto(photoname);
		
		try {
			upload.transferTo(new File(realPath+"/"+photoname));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// db insert
		shopService.insertShop(dto);
		
		return "redirect:/"; // 현재폴더
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(@RequestParam String num) {
		ModelAndView mview=new ModelAndView();
		
		ShopDto dto=shopService.getData(num);
		
		mview.addObject("dto", dto);
		
		mview.setViewName("myshop/shopDetail");
		
		return mview;
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String num, HttpSession session) {
		
		// 사진 삭제
		String oldFileName=shopService.getData(num).getPhoto();
		String realPath=session.getServletContext().getRealPath("/photo");
		
		File file=new File(realPath+"/"+oldFileName);
		if(file.exists()) {
			file.delete();
		}
		
		// db 삭제
		shopService.deleteShop(num);
		return "redirect:/";
	}
}
