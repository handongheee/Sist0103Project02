package boot.guest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.guest.dto.GuestDto;
import boot.guest.mapper.GuestMapper;

@Service
public class GuestService {

	@Autowired
	GuestMapper mapper;
	
	public int getTotalCount()
	{
		return mapper.getTotalCount();
	}
	
	public void insertGuest(GuestDto dto)
	{
		mapper.insertGuest(dto);
	}
	
	public List<GuestDto> getAllDatas()
	{
		return mapper.getAllDatas();
	}
}