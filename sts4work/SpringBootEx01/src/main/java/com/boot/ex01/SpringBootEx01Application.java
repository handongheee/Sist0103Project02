package com.boot.ex01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.test", "hello.boot", "sist.boot"}) // 패키지 등록
public class SpringBootEx01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEx01Application.class, args);
	}

}
