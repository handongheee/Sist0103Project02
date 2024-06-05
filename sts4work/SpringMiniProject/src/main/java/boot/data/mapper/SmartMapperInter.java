package boot.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.IpgoDto;
import boot.data.dto.SmartDto;

@Mapper
public interface SmartMapperInter {

	public int getTotalCount(); // 메서드명이 Sql의 id가 된다
	public void insertSmart(SmartDto dto);
	public List<SmartDto> getAllDatas();
	public SmartDto getData(String num);
	public void updateSmart(SmartDto dto);
	public void deleteSmart(String num);
}
