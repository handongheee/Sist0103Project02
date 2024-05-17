package info.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InfoDao {

	@Autowired
	InfoDaoInter daoInter;
	
	public void insertInfo(InfoDto dto) {
		daoInter.save(dto);
	}
	
	public List<InfoDto> getAllDatas(){
		return daoInter.findAll();
	}
	
	public InfoDto getData(Integer num) {
		return daoInter.getReferenceById(num);
	}
	
	public void updateInfo(InfoDto dto) {
		daoInter.save(dto);
	}
	
	public void deleteInfo(Integer num) {
		daoInter.deleteById(num);
	}
}
