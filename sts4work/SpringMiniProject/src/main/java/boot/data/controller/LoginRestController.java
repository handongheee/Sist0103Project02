package boot.data.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;

@RestController
public class LoginRestController {
	
	@Autowired
	MemberService service;

	// 세션 생성
	@GetMapping("/member/login")
	public Map<String, String> loginprocess(String id, String pass, HttpSession session){
		Map<String, String> map=new HashMap<>();
		
		int result=service.loginIdPassCheck(id, pass);
		
		if(result==1) {
			session.setMaxInactiveInterval(60*60*4); // 4시간
			
			// 로그인한 아이디로 정보 얻어 세션에 저장
			MemberDto mdto=service.getDataById(id);
			
			session.setAttribute("loginok", "yes");
			session.setAttribute("myid", id);
			session.setAttribute("loginname", mdto.getName());
			session.setAttribute("loginphoto", mdto.getPhoto());
		}
		
		map.put("result", result==1?"success":"fail");
		
		return map;
	}
	
	// 세션 제거
	@GetMapping("/member/logout")
	public void logoutprocess(HttpSession session){
		// 로그아웃 시 제거할 세션
		session.removeAttribute("loginok");
		session.removeAttribute("myid");
	}
}
