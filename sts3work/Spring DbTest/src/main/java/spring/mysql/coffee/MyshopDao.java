package spring.mysql.coffee;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyshopDao implements MyshopDaoInter {
	
	@Autowired // 자동주입
	private SqlSession session;
	
	@Override
	public List<MyshopDao> getAllList() {
		// TODO Auto-generated method stub	
		return session.selectList("getAllMyShop");
	}
}
