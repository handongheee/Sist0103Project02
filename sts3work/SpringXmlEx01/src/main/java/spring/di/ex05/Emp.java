package spring.di.ex05;

public class Emp {
	SawonInfo info;
	private String empname;
	private String emploc;
	
	// 생성자 주입
	public Emp(String empname) {
		// TODO Auto-generated constructor stub
		this.empname=empname;
	}
	
	// setter 주입
	public SawonInfo getInfo() {
		return info;
	}

	public void setInfo(SawonInfo info) {
		this.info = info;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmploc() {
		return emploc;
	}

	public void setEmploc(String emploc) {
		this.emploc = emploc;
	}
	
	// 출력메서드
	public void writeEmp() {
		System.out.println("회사명: "+empname);
		System.out.println("회사위치: "+emploc);
		System.out.println("사원명: "+info.getName());
		System.out.println("급여: "+info.getPay());
		System.out.println("직급: "+info.getPosition());
		System.out.println("부서명: "+info.getBuseo());
	}
}
