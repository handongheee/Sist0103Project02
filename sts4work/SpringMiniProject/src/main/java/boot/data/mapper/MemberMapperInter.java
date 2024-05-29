package boot.data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.MemberDto;

@Mapper
public interface MemberMapperInter {

	public void insertMember(MemberDto dto); // 추가
	public List<MemberDto> getAllMembers(); // 전체출력
	public int getSearchId(String id); // 아이디 중복 확인
	
	public String getName(String id); // 이름 구하기
	public int loginIdPassCheck(Map<String, String> map);
	public MemberDto getDataById(String id);
	
	public void deleteMember(String num); // 삭제
	
	public MemberDto getDataByNum(String num);
	public void updatePhoto(Map<String, String> map);
}
