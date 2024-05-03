package spring.di.ex05;

import java.util.ArrayList;

public class SawonInfo {
	private String name;
	private ArrayList<String> buseo;
	private int pay;
	private String position;
	
	// 생성자 주입
	public SawonInfo(String name, String position) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.position=position;
	}
	
	// getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getBuseo() {
		return buseo;
	}

	public void setBuseo(ArrayList<String> buseo) {
		this.buseo = buseo;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
