package spring.di.ex04;

import java.util.ArrayList;

public class Student {
	private String name;
	private ArrayList<String> hobby;
	private int age;
	
	// 명시적생성자
	public Student(String name, int age) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.age=age;
	}
	
	// setter getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getHobby() {
		return hobby;
	}

	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
