package boot.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.IpgoDto;

@Mapper
public interface IpgoMapperInter {

	public int getTotalCount(); // 메서드명이 Sql의 id가 된다
	public void insertIpgo(IpgoDto dto);
	public List<IpgoDto> getAllDatas();
	// 수정
	public IpgoDto getData(String num);
	public void updateIpgo(IpgoDto dto);
	// 삭제
	public void deleteIpgo(String num);
}
