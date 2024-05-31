package boot.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import boot.data.dto.AnswerMBoardDto;

public interface AnsMBoardServiceInter {

	public void insertAnswer(AnswerMBoardDto dto);
	public List<AnswerMBoardDto> getAllAnswer(String num);
	public AnswerMBoardDto getAnswer(String idx);
	public void updateAnswer(AnswerMBoardDto dto);
	public void deleteAnswer(String idx);
}
