package mycar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import mycar.data.MyCarDto;

public interface MyCarDaoInter extends JpaRepository<MyCarDto, Long> {

	// 직접 쿼리문 작성_수정메서드
	// 자동차명, 가격, 색상만 수정하는 메서드 작성
	
	@Query(value = "update mycar set carname=:carname, carprice=:carprice, carcolor=:carcolor where num=:num", nativeQuery = true)
	@Modifying // @Modifying: insert/update/delete 뿐 아니라 DDL 구문 사용 시 반드시 사용
	@Transactional // @Transactional: update, delete 사용 시 반드시 사용
	public void updateMycarNoPhoto(@Param("num") Long num, @Param("carname") String carname, @Param("carprice") String carprice, @Param("carcolor") String carcolor);
}