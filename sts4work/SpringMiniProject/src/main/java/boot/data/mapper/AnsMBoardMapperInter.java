package boot.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.AnswerMBoardDto;

@Mapper
public interface AnsMBoardMapperInter {
	
	public void insertAnswer(AnswerMBoardDto dto);
	public List<AnswerMBoardDto> getAllAnswer(String num);
	public AnswerMBoardDto getAnswer(String idx);
	public void updateAnswer(AnswerMBoardDto dto);
	public void deleteAnswer(String idx);

}
