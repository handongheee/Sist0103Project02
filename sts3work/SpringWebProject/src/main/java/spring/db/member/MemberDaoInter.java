package spring.db.member;

import java.util.List;

public interface MemberDaoInter {
	public int getIdCheck(String id);
	public int getTotalCount();
	public List<MemberDto> getAllDatas();
	public void insertMember(MemberDto dto);

}
