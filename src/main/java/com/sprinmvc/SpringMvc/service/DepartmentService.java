package com.sprinmvc.SpringMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sprinmvc.SpringMvc.dao.DepartmentDao;
import com.sprinmvc.SpringMvc.utilities.DeptModel;

@Component
public class DepartmentService {
	@Autowired
	DepartmentDao deptDao;

	// get all department
	public List<DeptModel> getAllDeptService() {
		return deptDao.getAllDepartment();
	}

	// get one department
	public DeptModel getOneDeptService(int dept_id) {

		return deptDao.getOneDepartment(dept_id);
	}

	// add department
	public int addDeptService(DeptModel dept) {

		int random = (int) (Math.random() * 1000);
		System.out.println(random);
		dept.setDept_id(random);
		System.out.println(dept.getDept_id());
		return deptDao.addDepartment(dept);
	}

	// update department
	public int updateDeptService(DeptModel dept) {

		return deptDao.updateDepartment(dept);
	}

	// delete department
	public int deleteDeptService(int id) {

		return deptDao.deleteDepartment(id);
	}

}
