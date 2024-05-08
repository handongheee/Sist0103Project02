package spring.db.may;

import java.util.List;

public interface SpringCarDaoInter {
	
	public int getTotalCount();
	public void insertCar(SpringCarDto dto);
	public List<SpringCarDto> getAllCarDatas();
	public SpringCarDto getData(String num);
	public void updateCar(SpringCarDto dto);
	public void deleteCar(String num);

}
