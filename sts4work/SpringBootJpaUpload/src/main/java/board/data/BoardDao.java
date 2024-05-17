package board.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository // bean 등록
public class BoardDao {
	@Autowired
	BoardDaoInter daoInter;
	
	// insert
	public void insertBoard(BoardDto dto) {
		daoInter.save(dto);
	}
	
	// list 출력
	public List<BoardDto> getAllDatas(){
		// 최신글 위로 올려주기. num 기준으로 정렬
		return daoInter.findAll(Sort.by(Sort.Direction.DESC, "num"));
	}
	
	// detail
	public BoardDto getData(Long num) {
		return daoInter.getReferenceById(num);
	}
	
	// update
	public void updateBoard(BoardDto dto) {
		daoInter.save(dto);
	}
	
	public void deleteBoard(Long num) {
		daoInter.deleteById(num);
	}
	
}
