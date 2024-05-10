package spring.db.member;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // bean 등록
public class MemberDao implements MemberDaoInter {

	@Autowired
	private SqlSession session;
	
	// 아이디중복체크
	@Override
	public int getIdCheck(String id) {
		// TODO Auto-generated method stub
		return session.selectOne("idCheckOfMember", id);
	}

	// 전체조회
	@Override
	public List<MemberDto> getAllDatas() {
		// TODO Auto-generated method stub
		return session.selectList("selectAllOfMember");
	}

	// insert
	@Override
	public void insertMember(MemberDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfMember", dto);
	}

	// 개수 구하기
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("totalCountOfMember");
	}

	// 한명의 정보 가져오기
	@Override
	public MemberDto getMember(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("selectOneOfMember", num);
	}

	// 비밀번호 체크
	@Override
	public int passCheck(String num, String pass) {
		// TODO Auto-generated method stub
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("num", num);
		map.put("pass", pass);
		
		return session.selectOne("passCheckOfMember", map);
	}

	// update
	@Override
	public void updateMember(MemberDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfMember", dto);
	}

	// 삭제
	@Override
	public void deleteMember(String num) {
		// TODO Auto-generated method stub
		session.delete("deleteOfMember", num);
	}

}
