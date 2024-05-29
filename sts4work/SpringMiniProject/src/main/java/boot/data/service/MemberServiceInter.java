package boot.data.service;

import java.util.List;
import java.util.Map;

import boot.data.dto.MemberDto;

public interface MemberServiceInter {
	public void insertMember(MemberDto dto); // 추가
	public List<MemberDto> getAllMembers(); // 전체출력
	public int getSearchId(String id); // 아이디 중복 확인
	
	public String getName(String id);
	public int loginIdPassCheck(String id, String pass);
	public MemberDto getDataById(String id);
	
	public void deleteMember(String num);
	
	public MemberDto getDataByNum(String num);
	public void updatePhoto(String num, String photo);
}
