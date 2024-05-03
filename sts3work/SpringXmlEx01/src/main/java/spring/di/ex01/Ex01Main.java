package spring.di.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1. 자바 방식 출력_생성 후 호출");
		MessageInter mi1=new Message01();
		mi1.sayHello("한동희");
		
		MessageInter mi2=new Message02();
		mi2.sayHello("민영");
		
		
		System.out.println("2. 스프링 방식 출력");
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext01.xml");
		
		// 방법01
		MessageInter mi3=(Message01)context.getBean("msgBean01");
		mi3.sayHello("변우석");
		
		// 방법02
		MessageInter mi4=context.getBean("msgBean02", Message02.class);
		mi4.sayHello("혜윤");
 	}

}
