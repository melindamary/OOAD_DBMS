package com.ilp03.entity;

public class Employee {
	private int employee_id;
	private String employee_firstname;
	private String employee_secondname;
	private String email;
	
	public Employee(int employee_id, String employee_firstname, String employee_secondname, String email) {
		super();
		this.employee_id = employee_id;
		this.employee_firstname = employee_firstname;
		this.employee_secondname = employee_secondname;
		this.email = email;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_firstname() {
		return employee_firstname;
	}

	public void setEmployee_firstname(String employee_firstname) {
		this.employee_firstname = employee_firstname;
	}

	public String getEmployee_secondname() {
		return employee_secondname;
	}

	public void setEmployee_secondname(String employee_secondname) {
		this.employee_secondname = employee_secondname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
