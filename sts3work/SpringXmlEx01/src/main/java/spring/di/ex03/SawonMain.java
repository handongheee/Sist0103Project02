package spring.di.ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SawonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext scontext=new ClassPathXmlApplicationContext("appContext03.xml");
		
		Sawon s=(Sawon)scontext.getBean("sa");
		s.writeData();
		
		Sawon s2=scontext.getBean("sa2", Sawon.class);
		s2.writeData();
	}

}
