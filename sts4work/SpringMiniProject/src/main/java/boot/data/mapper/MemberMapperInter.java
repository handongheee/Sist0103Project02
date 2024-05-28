package boot.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.MemberDto;

@Mapper
public interface MemberMapperInter {

	public void insertMember(MemberDto dto); // 추가
	public List<MemberDto> getAllMembers(); // 전체출력
	public int getSearchId(String id); // 아이디 중복 확인
}
