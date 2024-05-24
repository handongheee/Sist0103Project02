package boot.guest.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Alias("GuestDto")
public class GuestDto {

	private int num;
	private String nick;
	private String pass;
	private String photo;
	private String content;
	private int likes;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Timestamp writeday;
	
}
