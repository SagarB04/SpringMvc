package com.sprinmvc.SpringMvc.utilities;

import org.springframework.stereotype.Component;

@Component
public class EmpModel {

	private int emp_id=0;
	private String fname;
	private int sal;
	private String job_id;

	public EmpModel(int emp_id, String fname, String job_id, int sal) {
		super();
		this.emp_id = emp_id;
		this.fname = fname;
		this.job_id = job_id;
		this.sal = sal;
	}

	public EmpModel() {
		super();
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "EmpModel [emp_id=" + emp_id + ", fname=" + fname + ", job_id=" + job_id + ", sal=" + sal + "]";
	}

}
