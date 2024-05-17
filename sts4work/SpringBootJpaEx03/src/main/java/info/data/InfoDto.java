package info.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="info")
@Data
public class InfoDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num;
	
	@Column
	private String stuname;
	@Column
	private String stuhp;
	@Column
	private String stuaddr;
	@Column
	private String stuphoto;

}
