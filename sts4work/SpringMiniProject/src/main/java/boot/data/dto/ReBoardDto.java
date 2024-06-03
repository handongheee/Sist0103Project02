package boot.data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ReBoardDto")
public class ReBoardDto {
	private int num;
	private String id;
	private String name;
	private String subject;
	private String content;
	private String photo;
	private int readcount;
	private int likes;
	private int regroup;
	private int restep;
	private int relevel;
	private Timestamp writeday;
	
}
