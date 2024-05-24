package boot.guest.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import boot.guest.dto.GuestDto;
import boot.guest.service.GuestService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GuestInsertController {

	@Autowired
	private GuestService gService;
	
	String photo; // 전역변수, 업로드한 이미지 insert할때 dto에 담기 위함. 두 메서드 포토에 업로드 후 dto에 다시 담기 위해 선언?
	
	@PostMapping("/guest/upload")
	@ResponseBody
	public Map<String, String> upload(HttpServletRequest request,
			@RequestParam ArrayList<MultipartFile> photos){
		// 이미지 저장경로
		String path=request.getServletContext().getRealPath("/guestphoto");
		
		// 이미지 저장 클래스 선언 후 업로드
		photo="";
		
		if(photos.get(0).getOriginalFilename().equals("")) {
			photo="no";
		} else {
			for(MultipartFile f:photos) {
				String fName=f.getOriginalFilename();
				photo+=fName+",";
				
				try {
					f.transferTo(new File(path+"/"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			photo=photo.substring(0, photo.length()-1);
		}
		
		Map<String, String> map=new HashMap<>();
		
		this.photo=photo;
		map.put("photoname", photo);
		
		return map;
	}
	
	@PostMapping("/guest/insert")
	@ResponseBody
	public Map<String, String> insert(@ModelAttribute GuestDto dto){
		dto.setPhoto(photo);
		gService.insertGuest(dto);
		
		Map<String, String> map=new HashMap<>();
		
		// 호출한 곳으로 일단 메세지 보내기
		map.put("msg", "insert 성공");
	
		return map;
	}
}
