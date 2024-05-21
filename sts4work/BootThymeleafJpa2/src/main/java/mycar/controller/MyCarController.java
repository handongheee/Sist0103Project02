package mycar.controller;

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

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import mycar.data.MyCarDto;
import mycar.repository.MyCarCommentDao;
import mycar.repository.MyCarDao;

@Controller
@RequiredArgsConstructor
public class MyCarController {

	private final MyCarDao dao;
	
	// 멤버변수 추가
	private final MyCarCommentDao commentDao;
	
	
	@GetMapping("/")
	public String start()
	{
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String list(Model model)
	{
		
		List<MyCarDto> list=dao.getAllcars();
		
		// 댓글 개수 출력
		for(MyCarDto dto:list) {
			// 댓글 개수 저장
			int acount=commentDao.getMyCarCommentList(dto.getNum()).size();
			dto.setCommentcount(acount);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("total", list.size());
		
		return "mycar/mycarList";
	}
	
	@GetMapping("/writeform")
	public String form()
	{
		return "mycar/mycarForm";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MyCarDto dto,@RequestParam MultipartFile carupload,
			HttpSession session)
	{
		
		String realPath=session.getServletContext().getRealPath("/save");
		System.out.println(realPath);
		
		String uploadName=carupload.getOriginalFilename();
		
		dto.setCarphoto(uploadName);
		
		//실제업로드
		try {
			carupload.transferTo(new File(realPath+"/"+uploadName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//db에 저장
		dao.insertMyCar(dto);
		
		return "redirect:list";
	}
	
	// 상세보기
	@GetMapping("/detail")
	public String detail(@RequestParam Long num, Model model) {
		MyCarDto dto=dao.getData(num);
		
		// 저장
		model.addAttribute("dto", dto);
		
		return "mycar/mycarDetail";
	}
	
	// 수정폼 출력
	@GetMapping("/updateform")
	public String uform(@RequestParam Long num, Model model) {
		MyCarDto dto=dao.getData(num);
		
		// 저장
		model.addAttribute("dto", dto);
		return "mycar/updateForm";
	}
	
	// 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam Long num, HttpSession session) {
		
		// 사진부터 삭제
		String carphoto=dao.getData(num).getCarphoto();
		String realPath=session.getServletContext().getRealPath("/save");
		
		// 파일 객체 생성 후 삭제
		File file=new File(realPath+"/"+carphoto);
		if(file.exists()) {
			file.delete();
		}
		
		// db 삭제
		dao.deleteMycar(num);
		
		return "redirect:list";
	}
	
	// 수정
	@PostMapping("/update")
	public String update(@ModelAttribute MyCarDto dto, @RequestParam MultipartFile upload,
			HttpSession session) {
		if(upload.getOriginalFilename().equals("")) {
			// 사진 선택 안하면 사진 수정 안되게
			dao.updateMycarNoPhoto(dto);
		} else {
			// 사진 선택하면 사진 수정되게
			String realPath=session.getServletContext().getRealPath("/save");
			
			String uploadName=upload.getOriginalFilename();
			
			dto.setCarphoto(uploadName);
			
			// 실제 업로드
			try {
				upload.transferTo(new File(realPath+"/"+uploadName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// db 업데이트
			dao.updateMycar(dto);
		}
		// 수정 후 상세보기
		return "redirect:detail?num="+dto.getNum();
	}
	
}