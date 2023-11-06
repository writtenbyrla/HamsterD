package com.hd.hamsterD.model;

import java.util.Objects;

public class Member {

	private String password;
	private String name;
    private int age;
    private String academy;
    private int personalNum;
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public int getPersonalNum() {
		return personalNum;
	}
	public void setPersonalNum(int personalNum) {
		this.personalNum = personalNum;
	}
	@Override
	public String toString() {
		return "Member [password=" + password + ", name=" + name + ", age=" + age + ", academy=" + academy
				+ ", personalNum=" + personalNum + "]";
	}
	public Member(String password, String name, int age, String academy, int personalNum) {
		super();
		this.password = password;
		this.name = name;
		this.age = age;
		this.academy = academy;
		this.personalNum = personalNum;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}
	
}
