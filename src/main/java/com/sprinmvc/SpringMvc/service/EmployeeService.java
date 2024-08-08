package com.sprinmvc.SpringMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sprinmvc.SpringMvc.dao.EmployeeDao;
import com.sprinmvc.SpringMvc.utilities.EmpModel;

@Component
public class EmployeeService {

	@Autowired
	EmployeeDao empDao;

	// get all employee
	public List<EmpModel> getAllEmployeesService() {

		return empDao.getAllEmployees();
	}

	// get one employee
	public EmpModel getEmployeeService(int id) {

		return empDao.getEmplyee(id);
	}

	// delete employee
	public int deleteEmployeeService(int id) {

		return empDao.deleteEmployee(id);
	}

	// add employee
	public int addEmployeeService(EmpModel emp) {

		int id = (int) (Math.random() * 1000);
		emp.setEmp_id(id);

		return empDao.addEmployee(emp);
	}

	// update employee
	public int updateEmployeeService(EmpModel emp) {

		return empDao.updateEmployee(emp);
	}

}
