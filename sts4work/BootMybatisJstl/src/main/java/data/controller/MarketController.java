package data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import data.dto.MarketDto;
import data.mapper.MarketMapperInter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MarketController {

	@Autowired // 자동주입
	MarketMapperInter mapper;

	@GetMapping("/")
	public String start() {
		return "redirect:market/list";
	}

	@GetMapping("/market/list")
	public ModelAndView list() {
		ModelAndView mview = new ModelAndView();

		// db로부터 총 개수 얻기
		int totalCount = mapper.getTotalCount();
		List<MarketDto> list=mapper.getAllDatas();

		// 저장
		mview.addObject("totalCount", totalCount);
		mview.addObject("list", list);

		// 포워드
		mview.setViewName("market/marketList");

		return mview;
	}

	@GetMapping("/market/addform")
	public String form() {
		return "market/addForm";
	}
	
	// 추가
	@PostMapping("/market/insert")
	public String insert(@ModelAttribute MarketDto dto, 
			@RequestParam MultipartFile photo, HttpServletRequest request) {
		
		String path=request.getServletContext().getRealPath("/photo");
		System.out.println(path);
		
		if(photo.getOriginalFilename().equals("")) {
			dto.setPhotoname(null);
		} else {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			String photoname=sdf.format(new Date())+photo.getOriginalFilename();
			dto.setPhotoname(photoname);
			
			// 실제 이미지 업로드
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
		
		// db 저장
		mapper.insertMarket(dto);

		return "redirect:list";
	}
	
	// 수정폼
	@GetMapping("/market/updateform")
	public ModelAndView uform(@RequestParam String num) {
		ModelAndView mview=new ModelAndView();
		
		MarketDto dto=mapper.getOneData(num);
		
		mview.addObject("dto", dto); // 저장
		
		mview.setViewName("market/updateForm"); // 포워드
		
		return mview;
	}
	
	// 수정
	@PostMapping("/market/update")
	public String update(@ModelAttribute MarketDto dto, 
			@RequestParam MultipartFile photo, HttpServletRequest request) {
		
		String path=request.getServletContext().getRealPath("/photo");
		System.out.println(path);
		
		if(photo.getOriginalFilename().equals("")) {
			dto.setPhotoname(null);
		} else {
			// 수정 전에 이전 이미지 지우기
			String prev_photo=mapper.getOneData(dto.getNum()).getPhotoname();
			File file=new File(path+"/"+prev_photo);
			
			if(file.exists()) {
				file.delete();
			}
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			String photoname=sdf.format(new Date())+photo.getOriginalFilename();
			dto.setPhotoname(photoname);
			
			// 실제 이미지 업로드
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
		
		// db 저장
		mapper.updateMarket(dto);

		return "redirect:list";
	}

	// 삭제
	@GetMapping("/market/delete")
	public String delete(@RequestParam String num, HttpSession session) {
		String photo=mapper.getOneData(num).getPhotoname();
		
		if(!photo.equals(null)) {
			String path=session.getServletContext().getRealPath("/photo");
			File file=new File(path+"/"+photo);
			
			if(file.exists()) {
				file.delete();
			}
		}
		
		mapper.deleteMarket(num);
		
		return "redirect:list";
	}
}
