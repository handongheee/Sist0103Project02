package boot.guest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.guest.dto.GuestDto;

@Mapper
public interface GuestMapper {
	
	public int getTotalCount();
	public void insertGuest(GuestDto dto);
	public List<GuestDto> getAllDatas();
}
