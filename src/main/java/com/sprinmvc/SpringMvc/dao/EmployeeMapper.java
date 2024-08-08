package com.sprinmvc.SpringMvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.sprinmvc.SpringMvc.utilities.EmpModel;

public class EmployeeMapper implements RowMapper<EmpModel> {

	@Autowired
	EmpModel emp;

	@Override
	public EmpModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		emp = new EmpModel();

		try {

			emp.setEmp_id(rs.getInt(1));
			emp.setFname(rs.getString(2));
			emp.setJob_id(rs.getString(7));
			emp.setSal(rs.getInt(8));

		} catch (SQLException e) {
			System.out.println("err at mapper " + e);
		}

		return emp;
	}


}
