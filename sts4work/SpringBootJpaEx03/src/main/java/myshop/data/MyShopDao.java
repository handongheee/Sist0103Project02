package myshop.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // bean 등록

public class MyShopDao {

	@Autowired
	MyShopDaoInter daoInter;
	
	// insert
	public void insertShop(MyShopDto dto) {
		daoInter.save(dto); // id 타입 유무에 따라 자동으로 insert(무) 또는 update(유) 
	}
}
