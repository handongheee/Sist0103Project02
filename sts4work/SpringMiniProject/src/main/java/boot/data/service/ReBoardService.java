package boot.data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.data.dto.ReBoardDto;
import boot.data.mapper.ReBoardMapperInter;

@Service
public class ReBoardService implements ReBoardServiceInter {

	@Autowired
	ReBoardMapperInter mapperInter;

	@Override
	public int getTotalCount(String searchcolumn, String searchword) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<>();
		map.put("searchcolumn", searchword);
		map.put("searchword", searchword);
		
		return mapperInter.getTotalCount(map);
	}

	@Override
	public void insertReBoard(ReBoardDto dto) {
		// TODO Auto-generated method stub
		int num=dto.getNum(); // 새 글이면 이미 0 들어가 있음 
		int regroup=dto.getRegroup();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
		
		if(num==0) { // 새글일 경우
			
			regroup=this.getMaxNum()+1;
			restep=0;
			relevel=0;
			
		} else { // 답글인 경우
			
			// 같은 그룹 중에서 전달받은 restep보다 큰 값들은 모두 일괄 +1
			this.updateRestep(regroup, restep);
			
			// 전달받은 값보다 1 크게 db에 저장
			restep++;
			relevel++;
			
		}
		
		// 변경된 값들은 다시 dto에 넣는다
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		// insert
		mapperInter.insertReBoard(dto);
	}

	@Override
	public List<ReBoardDto> getPagingList(String searchcolumn, String searchword, int startnum, int perpage) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		map.put("searchcolumn", searchcolumn);
		map.put("searchword", searchword);
		map.put("startnum", startnum);
		map.put("perpage", perpage);
		
		return mapperInter.getPagingList(map);
	}

	@Override
	public ReBoardDto getData(int num) {
		// TODO Auto-generated method stub
		return mapperInter.getData(num);
	}

	@Override
	public void updateRestep(int regroup, int restep) {
		// TODO Auto-generated method stub
		Map<String, Integer> map=new HashMap<>();
		map.put("regroup", regroup);
		map.put("restep", restep);
		
		mapperInter.updateRestep(map);
	}

	@Override
	public void updateReadCount(int num) {
		// TODO Auto-generated method stub
		mapperInter.updateReadCount(num);
	}

	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return mapperInter.getMaxNum();
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		 mapperInter.deleteBoard(num);
	}

	@Override
	public void likesUpdate(int num) {
		// TODO Auto-generated method stub
		mapperInter.likesUpdate(num);
	}
	
}
