package com.sprinmvc.SpringMvc.utilities;

import org.springframework.stereotype.Component;

@Component
public class DeptModel {
	private int dept_id;
	private String dept_name;
	private int manager_id;
	private int loc_id;

	public DeptModel() {
		super();
	}

	public DeptModel(int dept_id, String dept_name, int manager_id, int loc_id) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.manager_id = manager_id;
		this.loc_id = loc_id;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public int getLoc_id() {
		return loc_id;
	}

	public void setLoc_id(int loc_id) {
		this.loc_id = loc_id;
	}

	@Override
	public String toString() {
		return "DeptModel [dept_id=" + dept_id + ", dept_name=" + dept_name + ", manager_id=" + manager_id + ", loc_id="
				+ loc_id + "]";
	}

}
