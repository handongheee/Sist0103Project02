package boot.data.service;

import java.util.HashMap;
import java.util.List;

import boot.data.dto.MemBoardDto;

public interface MemBoardServiceInter {

	public int getTotalCount();
	public void insertMemBoard(MemBoardDto dto); // 추가
	public List<MemBoardDto> getList(int start, int perpage); // 페이징
	public MemBoardDto getData(String num);
	public void updateReadCount(String num);
	public int getMaxNum();
}
