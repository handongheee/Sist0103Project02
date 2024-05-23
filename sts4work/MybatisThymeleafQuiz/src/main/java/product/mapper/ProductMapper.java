package product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import product.dto.ProductDto;

@Mapper
public interface ProductMapper {
	
	public int getTotalCount();
	
	public void insertProduct(ProductDto dto);
	
	@Select("select * from product order by pro_num asc")
	public List<ProductDto> getAllSangpums();
	
	@Select("select * from product where pro_num=#{num}")
	public ProductDto getData(int num);

}
