package mycar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mycar.data.MyCarCommentDto;
import mycar.data.MyCarDto;
import mycar.repository.MyCarCommentDao;

@RestController
@RequiredArgsConstructor // final 또는 @NonNull 멤버 변수만 자동주입
public class MyCarCommentController {
	
	private final MyCarCommentDao commentDao;
	
	// 추가
	@GetMapping("/addcomment")
	public void addcomment(@RequestParam Long num, @RequestParam String comment) {
		
		// 먼저 MyCarDto에 num값을 넣은 후 MyCarCommentDto에 넣어준다(외부키로 지정된 값)
		
		MyCarDto dto=MyCarDto.builder().num(num).build();
		
		// dto에 값 지정
		MyCarCommentDto commentDto=MyCarCommentDto.builder()
				.comment(comment)
				.mycar(dto)
				.build();
		
		// db에 insert
		commentDao.insertCommentMyCar(commentDto);
	}
	
	// 부모글에 달린 댓글 반환
	@GetMapping("/commentlist")
	public List<MyCarCommentDto> commentList(@RequestParam Long num){
		return commentDao.getMyCarCommentList(num);
	}

}
