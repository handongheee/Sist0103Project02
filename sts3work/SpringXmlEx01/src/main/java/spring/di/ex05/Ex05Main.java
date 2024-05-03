package spring.di.ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex05Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appcon=new ClassPathXmlApplicationContext("appContext05.xml");
		
		Emp e=(Emp)appcon.getBean("einfo");
		e.writeEmp();
	}

}
