package boot.data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.ReBoardDto;

@Mapper // bean 등록
public interface ReBoardMapperInter {

	public int getTotalCount(Map<String, String> map);
	public void insertReBoard(ReBoardDto dto);
	public List<ReBoardDto> getPagingList(Map<String, Object> map);
	public ReBoardDto getData(int num);
	public void updateRestep(Map<String, Integer> map);
	public void updateReadCount(int num);
	public int getMaxNum();
	public void deleteBoard(int num);
	public void likesUpdate(int num);
	
}
