package myshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import myshop.dto.ShopDto;
import myshop.mapper.MyShopMapper;

@Service
@AllArgsConstructor
public class MyShopService {

	private final MyShopMapper shopMapper;
	
	public int getTotalCount() {
		return shopMapper.getTotalCount();
	}
	
	public void insertShop(ShopDto dto) {
		shopMapper.insertShop(dto);
	}
	
	public List<ShopDto> getAllSangpums() {
		return shopMapper.getAllSangpums();
	}
	
	public ShopDto getData(String num) {
		return shopMapper.getData(num);
	}
	
	public void deleteShop(String num) {
		shopMapper.deleteShop(num);
	}
}
