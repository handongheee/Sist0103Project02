package spring.db.may;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // bean에 등록
public class SpringCarDao implements SpringCarDaoInter {
	
	// sql 메서드 자동주입
	@Autowired
	private SqlSession session;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("totalCountOfCar");
	}
	
	@Override
	public void insertCar(SpringCarDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfMyCar", dto); // 파라미터가 있으니 2개짜리로
	}
	
	@Override
	public List<SpringCarDto> getAllCarDatas() {
		// TODO Auto-generated method stub
		return session.selectList("getAllOfMyCar");
	}
	
	@Override
	public SpringCarDto getData(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("selectOneOfCar", num);
	}
	
	@Override
	public void updateCar(SpringCarDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfCar", dto);
	}
	
	@Override
	public void deleteCar(String num) {
		// TODO Auto-generated method stub
		session.delete("deleteOfCar", num);
	}
}
