package boot.data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("IpgoDto")
public class IpgoDto {

	public String num;
	public String sangpum;
	public int price;
	public String photoname;
	public Timestamp ipgoday;
}
