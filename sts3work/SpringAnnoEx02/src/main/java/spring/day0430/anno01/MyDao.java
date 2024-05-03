package spring.day0430.anno01;

import org.springframework.stereotype.Component;

@Component // 자동으로 빈에 등록(id가 클래스명으로 자동 등록_첫글자만 소문자 myDao가 아이디가 됨)
public class MyDao implements DaoInter {

	@Override
	public void insertData(String str) {
		// TODO Auto-generated method stub
		System.out.println(str+"_데이터 db에 추가성공!");
	}

	@Override
	public void deleteData(String num) {
		// TODO Auto-generated method stub
		System.out.println(num+"_에 해당하는 데이터 삭제 성공");
	}

}
