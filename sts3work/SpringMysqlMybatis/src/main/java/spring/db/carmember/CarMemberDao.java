package spring.db.carmember;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarMemberDao implements CarMemberDaoInter {

	@Autowired
	private SqlSession session;
	
	// 조회, 추가
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("totalCountOfMember");
	}
	
	@Override
	public void insertMember(CarMemberDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfCarMember", dto);
	}
	
	@Override
	public List<CarMemberDto> getAllDatas() {
		// TODO Auto-generated method stub
		return session.selectList("selectAllOfMember");
	}

	// 수정, 삭제
	@Override
	public CarMemberDto getOneData(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("selectOneOfCarMember", num);
	}

	@Override
	public void updateCarMember(CarMemberDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfCarMember", dto);
	}

	@Override
	public void deleteMember(String num) {
		// TODO Auto-generated method stub
		session.delete("deleteOfCarMember", num);
	}

}
