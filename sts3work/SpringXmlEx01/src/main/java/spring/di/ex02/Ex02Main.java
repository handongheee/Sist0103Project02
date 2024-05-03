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
		System.out.println(my.toString()); // = my, toString()�� ���� �� �ڵ� ȣ��Ǵ� �޼���
		
		// Person
		Person p=(Person)context.getBean("person");
		p.writeData();
	}

}
