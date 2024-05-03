package spring.day0430.anno01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app1=new ClassPathXmlApplicationContext("annoContext1.xml");
		
		LogicController logic1=(LogicController)app1.getBean("logic");
		
		logic1.insert("스프링 xml 배우는 중");
		logic1.delete("3");

	}

}
