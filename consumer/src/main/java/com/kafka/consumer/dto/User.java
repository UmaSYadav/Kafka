package com.kafka.consumer.dto;

import java.io.Serializable;

public class User implements Serializable {
	private String sName;
	private String sDept;
	private double dSalary;
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsDept() {
		return sDept;
	}
	public void setsDept(String sDept) {
		this.sDept = sDept;
	}
	public double getdSalary() {
		return dSalary;
	}
	public void setdSalary(double dSalary) {
		this.dSalary = dSalary;
	}
	public User(String sName, String sDept, double dSalary) {
		super();
		this.sName = sName;
		this.sDept = sDept;
		this.dSalary = dSalary;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [sName=" + sName + ", sDept=" + sDept + ", dSalary=" + dSalary + "]";
	}
	
	
}
