package mycar.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import mycar.data.MyCarDto;

@Repository
@AllArgsConstructor // =autoweird. 모든 생성자 값 그대로 가져옴
public class MyCarDao {
	
	MyCarDaoInter daoInter;
	
	//db 저장
	public void insertMyCar(MyCarDto dto) {
		daoInter.save(dto);
	}
	
	// 전체 출력
	public List<MyCarDto> getAllcars(){
		
		return daoInter.findAll(); // 전체출력
		//return daoInter.findAll(Sort.by(Sort.Direction.DESC,"carprice")); // 가격 비싼거부터 출
	}
	
	public MyCarDto getData(Long num) {
		return daoInter.getReferenceById(num);
	}
	
	public void deleteMycar(Long num) {
		daoInter.deleteById(num);
	}
	
	public void updateMycar(MyCarDto dto) {
		daoInter.save(dto); // num 포함이므로 수정
	}
	
	public void updateMycarNoPhoto(MyCarDto dto) {
		Long num=dto.getNum();
		String carname=dto.getCarname();
		String carprice=dto.getCarprice();
		String carcolor=dto.getCarcolor();
		
		daoInter.updateMycarNoPhoto(num, carname, carprice, carcolor);
	}

}
