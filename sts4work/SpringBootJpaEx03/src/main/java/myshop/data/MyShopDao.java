package myshop.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // bean 등록

public class MyShopDao {

	@Autowired
	MyShopDaoInter daoInter;
	
	// insert - save
	public void insertShop(MyShopDto dto) {
		daoInter.save(dto); // id 타입 유무에 따라 자동으로 insert(무) 또는 update(유) 
	}
	
	// 전체출력 - findAll
	public List<MyShopDto> getAllSangpums(){
		return daoInter.findAll();
	}
	
	// num에 대한 dto 반환 - getReferenceById
	public MyShopDto getData(Long num) {
		return daoInter.getReferenceById(num);
	}
	
	// 수정
	public void updateShop(MyShopDto dto) {
		daoInter.save(dto); // num이 포함되어있으므로 수정이 됨
	}
	
	// 삭제 - deleteById
	public void deleteShop(long num) {
		daoInter.deleteById(num);
	}
}
