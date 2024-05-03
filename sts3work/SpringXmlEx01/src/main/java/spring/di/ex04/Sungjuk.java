package spring.di.ex04;

public class Sungjuk {
	Student stu;
	int kor, eng, math;
	
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public void writeSungjuk() {
		System.out.println("===== 기말고사 =====");
		System.out.println("학생명: "+stu.getName());
		System.out.println("나이: "+stu.getAge());
		System.out.println("국어 점수: "+kor);
		System.out.println("영어 점수: "+eng);
		System.out.println("수학 점수: "+math);
		
		System.out.println("나의 취미들");
		for(String hb:stu.getHobby()) {
			System.out.println("\t"+hb);
		}
	}
}
