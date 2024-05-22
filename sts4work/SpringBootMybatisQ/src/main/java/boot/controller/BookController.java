package boot.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.BookDto;
import boot.data.BookMapperInter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {

	@Autowired
	BookMapperInter mapper;
	
	@GetMapping("/")
	public String start() {
		return"redirect:book/list";
	}
	
	// 목록
	@GetMapping("/book/list")
	public ModelAndView list() {
		ModelAndView mview=new ModelAndView();
		
		int total=mapper.getTotalCount();
		List<BookDto> list=mapper.getAllDatas();
		
		mview.addObject("total", total);
		mview.addObject("list", list);
		
		mview.setViewName("book/bookList");
		
		return mview;
	}
	
	// 추가폼
	@GetMapping("/book/form")
	public String form() {
		return "book/addForm";
	}
	
	// insert
	@PostMapping("/book/insert")
	public String insert(@ModelAttribute BookDto dto,
			@RequestParam MultipartFile photo, HttpServletRequest request) {
		
		String path=request.getServletContext().getRealPath("/bookphoto");
		
		if(photo.getOriginalFilename().equals("")) {
			dto.setBookimage(null);
		} else {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			String photoname=sdf.format(new Date())+photo.getOriginalFilename();
			dto.setBookimage(photoname);
			
			try {
				photo.transferTo(new File(path+"/"+photoname));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		mapper.insertBook(dto);
		
		return "redirect:list";
	}
}
