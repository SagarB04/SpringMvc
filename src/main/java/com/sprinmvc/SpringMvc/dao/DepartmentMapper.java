package com.sprinmvc.SpringMvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.sprinmvc.SpringMvc.utilities.DeptModel;

public class DepartmentMapper implements RowMapper<DeptModel> {

	@Autowired
	DeptModel dept;
	
	@Override
	public DeptModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		dept = new DeptModel();
		
		try {

			dept.setDept_id(rs.getInt(1));
			dept.setDept_name(rs.getString(2));
			dept.setManager_id(rs.getInt(3));
			dept.setLoc_id(rs.getInt(4));

		} catch (SQLException e) {
			System.out.println("err at mapper " + e);
		}

		return dept;
	}

	

}
