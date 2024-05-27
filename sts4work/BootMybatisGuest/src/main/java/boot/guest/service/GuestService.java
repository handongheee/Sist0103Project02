package boot.guest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public int isEqualPassCheck(int num,String pass)
	{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", num);
		map.put("pass", pass);
		
		int n=mapper.isEqualPassCheck(num, pass);
		return n==1?1:0;
	}
	public void deleteGuest(int num)
	{
		mapper.deleteGuest(num);
	}
}