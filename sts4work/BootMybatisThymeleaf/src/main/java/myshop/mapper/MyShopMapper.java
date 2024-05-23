package myshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import myshop.dto.ShopDto;

@Mapper
public interface MyShopMapper {

	public int getTotalCount();
	public void insertShop(ShopDto dto);
	
	@Select("select * from myshop order by num asc")
	public List<ShopDto> getAllSangpums();
	
	@Select("select * from myshop where num=#{num}")
	public ShopDto getData(String num);
	
	// 삭제
	@Delete ("delete from myshop where num=#{num}")
	public void deleteShop(String num);
}
