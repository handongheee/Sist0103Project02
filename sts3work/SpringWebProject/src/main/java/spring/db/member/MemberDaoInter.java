package spring.db.member;

import java.util.HashMap;
import java.util.List;

public interface MemberDaoInter {
	public int getIdCheck(String id);
	public int getTotalCount();
	public List<MemberDto> getAllDatas();
	public void insertMember(MemberDto dto);

	// 수정 0510
	public MemberDto getMember(String num);
	public int passCheck(String num, String pass);
	public void updateMember(MemberDto dto);
	// 삭제
	public void deleteMember(String num);
}
