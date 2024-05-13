package spring.db.board;

import java.util.List;

public interface BoardDaoInter {

	public int getTotalCount();
	public int getMaxNum();
	public void insertBoard(BoardDto dto);
	public List<BoardDto> getAllList();
	
	// 상세보기
	public BoardDto getData(int num);
	public void updateReadcount(int num); // 조회수
	
	// 페이징
	public List<BoardDto> getList(int start, int perpage);
	
	// 수정, 삭제
	public void updateBoard(BoardDto dto);
	public void deleteBoard(int num);
	
	// ajax
	public List<BoardDto> getPhotoLists();
	
}
