package com.czg.hrm;

import java.util.Date;

/*
 * 本系统是一个非常简单的人事管理系统，可以对人员进行添加，删除，修改等操作
 * 可以浏览全部员工的信息并且进行查询
 * 员工的信息包括：编号，姓名，年龄，生日和通讯地址
 * */
public class Person {
	private int pid;
	private String name;
	private int age;
	private Date birthday;
	private String address;
//	构造方法
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(int pid, String name, int age, Date birthday, String address) {
		super();
		// TODO Auto-generated constructor stub
		this.pid = pid;
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.address = address;		
	}
	
//	对每一个属性的getter and setter 封装
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getPid()+"\t\t"+this.getName()+"\t\t"+this.getAge()+"\t\t"+this.getBirthday()+"\t\t"+this.getAddress();
	}
	
	
}
