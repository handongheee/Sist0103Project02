package spring.di.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1. �ڹ� ��� ���_���� �� ȣ��");
		MessageInter mi1=new Message01();
		mi1.sayHello("�ѵ���");
		
		MessageInter mi2=new Message02();
		mi2.sayHello("�ο�");
		
		
		System.out.println("2. ������ ��� ���");
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext01.xml");
		
		// ���01
		MessageInter mi3=(Message01)context.getBean("msgBean01");
		mi3.sayHello("���켮");
		
		// ���02
		MessageInter mi4=context.getBean("msgBean02", Message02.class);
		mi4.sayHello("����");
 	}

}
