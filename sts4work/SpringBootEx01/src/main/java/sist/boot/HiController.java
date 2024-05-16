package sist.boot;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
	@GetMapping("/sist/hi")
	public HashMap<String, String> hi(){
		HashMap<String, String> data=new HashMap<>();
		
		data.put("message", "Have a nice day!!");
		
		return data;
	}
}
