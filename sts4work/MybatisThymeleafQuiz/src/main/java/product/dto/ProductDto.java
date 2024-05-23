package product.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Alias("ProductDto")
public class ProductDto {
	
	private int pro_num;
	private String pro_name;
	private int pro_price;
	private String pro_color;
	private String pro_image;
	private Timestamp pro_create_date;

}
