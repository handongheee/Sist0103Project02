package spring.di.ex03;

public class SawonData {
	private String sawonname;
	private int pay;
	private String ipsaday;
	
	// 디폴트 생성자
	public SawonData() {
		// TODO Auto-generated constructor stub
	}
	
	// 명시적 생성자
	public SawonData(String name) {
		// TODO Auto-generated constructor stub
		sawonname=name;
	}
	
	// getter setter
	public String getSawonname() {
		return sawonname;
	}

	public void setSawonname(String sawonname) {
		this.sawonname = sawonname;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getIpsaday() {
		return ipsaday;
	}

	public void setIpsaday(String ipsaday) {
		this.ipsaday = ipsaday;
	}

}
