package spring.day0430.anno01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component ("logic") // ���̵� logic�� �ȴ�
public class LogicController {
	
	@Autowired // �ڵ�����, mydao�� ���� �̸��ΰſ� �ڵ����Ե�
	DaoInter inter;
	
	// ����Ʈ������
	public LogicController() {
		// TODO Auto-generated constructor stub
	}
	
	// ������
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
