package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.data.PhotoDto;

@RestController
public class JsonController02 {

	@GetMapping("/foodlist3")
	public Map<String, Object> list3(@RequestParam String foodname) {

		List<PhotoDto> list = new ArrayList<PhotoDto>();

		list.add(new PhotoDto("샌드위치", "1.jpg"));
		list.add(new PhotoDto("꼬치구이", "2.jpg"));
		list.add(new PhotoDto("망고빙수", "11.jpg"));
		list.add(new PhotoDto("포테이토리조또", "5.jpg"));
		list.add(new PhotoDto("토마토스튜", "7.jpg"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("foodname", "없는메뉴");
		map.put("photo", "6.jpg");

		for (PhotoDto dto : list) {
			if (foodname.equals(dto.getFoodname())) {
				map.put("foodname", dto.getFoodname());
				map.put("photo", dto.getPhoto());
			}
		}

		return map;

	}
}