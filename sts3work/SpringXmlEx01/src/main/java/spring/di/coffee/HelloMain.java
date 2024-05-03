package spring.di.coffee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("===== 자바 방식으로 Hello 메서드 호출하기 =====");
		
		Hello hello1=new Hello();
		Hello hello2=new Hello();
		
		System.out.println(hello1.getMessage());
		
		System.out.println(hello1==hello2); // 주소값(레퍼런스) 비교
		// 자바에서는 new로 생성할 때마다 새로운 영역에 생성한다 그래서 false 출력
		
		
		System.out.println("===== 스프링 방식으로 Hello 메서드 호출하기 =====");
		
		// 설정 xml 파일 가져온다 - 어플리케이션(콘솔) 실행 시에만 필요하다
		// 웹으로 실행 시 web.xml 에 기설정되어있으므로 필요 없다
		ApplicationContext app1=new ClassPathXmlApplicationContext("helloContext01.xml");
		
		// 이제 객체 생성 가능 
		// 방법01 (캐스팅)
		Hello h1=(Hello)app1.getBean("hello");
		System.out.println(h1.getMessage());
		
		// 방법 02
		Hello h2=app1.getBean("hello", Hello.class);
		System.out.println(h2.getMessage());
		
		System.out.println(h1==h2); // 생성되는 주소가 같음 => 스프링에서는 기본이 싱글톤 그래서 true
		
	}

}
