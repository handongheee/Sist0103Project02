package boot.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.data.dto.AnswerMBoardDto;
import boot.data.mapper.AnsMBoardMapperInter;

@Service
public class AnsMBoardService implements AnsMBoardServiceInter {

	@Autowired
	AnsMBoardMapperInter mapper;
	
	@Override
	public void insertAnswer(AnswerMBoardDto dto) {
		// TODO Auto-generated method stub
		mapper.insertAnswer(dto);
	}

	@Override
	public List<AnswerMBoardDto> getAllAnswer(String num) {
		// TODO Auto-generated method stub
		return mapper.getAllAnswer(num);
	}

	@Override
	public AnswerMBoardDto getAnswer(String idx) {
		// TODO Auto-generated method stub
		return mapper.getAnswer(idx);
	}

	@Override
	public void updateAnswer(AnswerMBoardDto dto) {
		// TODO Auto-generated method stub
		mapper.updateAnswer(dto);
	}

	@Override
	public void deleteAnswer(String idx) {
		// TODO Auto-generated method stub
		mapper.deleteAnswer(idx);
	}

}
