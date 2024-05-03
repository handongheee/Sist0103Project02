package spring.di.ex03;

public class Sawon {
	SawonData data;
	
	public Sawon(SawonData data) {
		// TODO Auto-generated constructor stub
		this.data=data;
	}
	
	public void writeData() {
		System.out.println("사원명: "+data.getSawonname());
		System.out.println("급여: "+data.getPay());
		System.out.println("입사일: "+data.getIpsaday());
	}
}
