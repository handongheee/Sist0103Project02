package spring.db.carmember;

import java.util.List;

public interface CarMemberDaoInter {
	public int getTotalCount();
	public void insertMember(CarMemberDto dto);
	public List<CarMemberDto> getAllDatas();
	
	public CarMemberDto getOneData(String num);
	public void updateCarMember(CarMemberDto dto); // 수정
	public void deleteMember(String num); // 삭제
}
