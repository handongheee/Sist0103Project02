package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.MarketDto;

@Mapper // bean 등록
public interface MarketMapperInter {

	public int getTotalCount();
	public void insertMarket(MarketDto dto);
	public List<MarketDto> getAllDatas();
	public MarketDto getOneData(String num);
	public void updateMarket(MarketDto dto);
	public void deleteMarket(String num);
	
	
}
