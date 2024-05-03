package spring.di.ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex02Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext02.xml");
		
		// MyInfo
		MyInfo my=(MyInfo)context.getBean("my");
		
		System.out.println(my); // = my.toString
		System.out.println(my.toString()); // = my, toString()은 생략 시 자동 호출되는 메서드
		
		// Person
		Person p=(Person)context.getBean("person");
		p.writeData();
	}

}
