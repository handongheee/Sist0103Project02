package spring.day0430.anno01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component ("logic") // 아이디가 logic이 된다
public class LogicController {
	
	@Autowired // 자동주입, mydao에 같은 이름인거에 자동주입됨
	DaoInter inter;
	
	// 디폴트생성자
	public LogicController() {
		// TODO Auto-generated constructor stub
	}
	
	// 생성자
	public LogicController(MyDao dao) {
		// TODO Auto-generated constructor stub
		this.inter=dao;
	}
	
	// insert
	public void insert(String str) {
		inter.insertData(str);
	}
	
	// delete
	public void delete(String num) {
		inter.deleteData(num);
	}
	
}
