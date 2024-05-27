package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.IpgoDto;
import boot.data.mapper.IpgoMapperInter;


@Controller
public class IpgoController {
	
	@Autowired
	IpgoMapperInter mapper;

	@GetMapping("/")
	public String start() {
		return "/layout/main";
	}
	
	@GetMapping("/ipgo/list")
	public ModelAndView list() {
		// 선언
		ModelAndView mview=new ModelAndView(); 
		
		// 메서드 받음
		int totalCount=mapper.getTotalCount();
		List<IpgoDto> list=mapper.getAllDatas();
		
		// 저장
		mview.addObject("totalCount", totalCount);
		mview.addObject("list", list);
		
		// 포워드
		//mview.setViewName("ipgo/ipgoList"); // ipgo/ipgoList.jsp로 포워드
		mview.setViewName("/ipgo/ipgoList"); // tiles
		
		return mview; // 리턴
	}
	
	@GetMapping("ipgo/writeform")
	public String form() {
		return "/ipgo/ipgoForm";
	}
	
	@PostMapping("/ipgo/insert")
	public String insert(@ModelAttribute IpgoDto dto, @RequestParam ArrayList<MultipartFile> upload,
			HttpSession session) {
		String path=session.getServletContext().getRealPath("/ipgoimage");
		
		String uploadName="";
		
		// 이미지 저장
		if(upload.get(0).getOriginalFilename().equals("")) {
			uploadName="no";
		} else {
			for(MultipartFile f:upload) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
				
				String fName=sdf.format(new Date())+"_"+f.getOriginalFilename();
				uploadName+=fName+",";
				
				// 업로드
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
			
			// 마지막 컴마 제거
			uploadName=uploadName.substring(0, uploadName.length()-1);
		}
		
		dto.setPhotoname(uploadName);
		
		mapper.insertIpgo(dto);
		
		return "redirect:list";
	}
}
