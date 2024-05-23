package product.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import product.dto.ProductDto;
import product.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {

	private final ProductService proService;
	
	@GetMapping("/")
	public String list(Model model) {
		
		int total=proService.getTotalCount();
		List<ProductDto> list=proService.getAllSangpums();
		
		model.addAttribute("total", total);
		model.addAttribute("list", list);
		
		return "product/productList";
	}
	
	@GetMapping("/addform")
	public String form() {
		return "product/addForm";
	}
	
	@PostMapping("insert")
	public String insert(@ModelAttribute ProductDto dto,
			@RequestParam MultipartFile upload, HttpSession session) {
		
		String realPath=session.getServletContext().getRealPath("/productImage");
		
		String photoname=upload.getOriginalFilename();
		dto.setPro_image(photoname);
		
		try {
			upload.transferTo(new File(realPath+"/"+photoname));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		proService.insertProduct(dto);
		
		return "redirect:/";
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(@RequestParam int num) {
		ModelAndView mview=new ModelAndView();
		
		ProductDto dto=proService.getData(num);
		mview.addObject("dto", dto);
		
		mview.setViewName("product/productDetail");
		
		return mview;
	}
}
