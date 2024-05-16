package com.boot.ex01;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString
@Data // setter+getter+toString=data
public class TestDto {
	
	private String name;
	private String addr;
	
}
