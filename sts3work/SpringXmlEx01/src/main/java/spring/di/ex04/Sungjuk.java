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
		System.out.println("===== �⸻��� =====");
		System.out.println("�л���: "+stu.getName());
		System.out.println("����: "+stu.getAge());
		System.out.println("���� ����: "+kor);
		System.out.println("���� ����: "+eng);
		System.out.println("���� ����: "+math);
		
		System.out.println("���� ��̵�");
		for(String hb:stu.getHobby()) {
			System.out.println("\t"+hb);
		}
	}
}
