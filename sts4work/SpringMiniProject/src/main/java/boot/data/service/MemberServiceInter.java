package boot.data.service;

import java.util.List;

import boot.data.dto.MemberDto;

public interface MemberServiceInter {
	public void insertMember(MemberDto dto); // 추가
	public List<MemberDto> getAllMembers(); // 전체출력
	public int getSearchId(String id); // 아이디 중복 확인
}
