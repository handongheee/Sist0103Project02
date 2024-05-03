package spring.di.ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.ex03.Sawon;

public class Ex04Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("appContext04.xml");
	
		Sungjuk sj=(Sungjuk)app.getBean("sj");
		sj.writeSungjuk();
	}
}
