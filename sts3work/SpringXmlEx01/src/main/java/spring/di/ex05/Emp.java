package spring.di.ex05;

public class Emp {
	SawonInfo info;
	private String empname;
	private String emploc;
	
	// ������ ����
	public Emp(String empname) {
		// TODO Auto-generated constructor stub
		this.empname=empname;
	}
	
	// setter ����
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
	
	// ��¸޼���
	public void writeEmp() {
		System.out.println("ȸ���: "+empname);
		System.out.println("ȸ����ġ: "+emploc);
		System.out.println("�����: "+info.getName());
		System.out.println("�޿�: "+info.getPay());
		System.out.println("����: "+info.getPosition());
		System.out.println("�μ���: "+info.getBuseo());
	}
}
