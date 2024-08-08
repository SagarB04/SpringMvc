package com.sprinmvc.SpringMvc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.sprinmvc.SpringMvc.utilities.DeptModel;

@Component
public class DepartmentDao {

	@Autowired
	JdbcTemplate jdbcTemp;

	@Autowired
	NamedParameterJdbcTemplate namedjdbcTemp;

	@Autowired
	PlatformTransactionManager transManager;

	@Autowired
	DeptModel dept;

	/**
	 * get all department
	 */
	public List<DeptModel> getAllDepartment() {

		List<DeptModel> list = new ArrayList<>();

		String query = "select * from dept";

		list = jdbcTemp.query(query, new DepartmentMapper());

		return list;
	}

	/**
	 * get one department
	 */
	public DeptModel getOneDepartment(int dept_id) {

		String query = "select * from dept where department_id=" + dept_id;

		dept = jdbcTemp.queryForObject(query, new DepartmentMapper());

		return dept;
	}

	/**
	 * add department
	 */
	public int addDepartment(DeptModel dept) {
		TransactionStatus transtatus = transManager.getTransaction(new DefaultTransactionDefinition());
		String query = "insert into dept values(:deptId, :deptName, :manId, :locId) ";
		int res = 1;

		try {

			Map<String, Object> map = new HashMap<>();
			map.put("deptId", dept.getDept_id());
			map.put("deptName", dept.getDept_name());
			map.put("manId", dept.getManager_id());
			map.put("locId", dept.getLoc_id());

			namedjdbcTemp.execute(query, map, new PreparedStatementCallback<Object>() {

				@Override
				public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

					return ps.executeUpdate();
				}
			});

			transManager.commit(transtatus);
		} catch (Exception e) {
			res = 0;
			transManager.rollback(transtatus);
			System.out.println(e);
		}

		return res;
	}

	/**
	 * update department
	 */
	public int updateDepartment(DeptModel dept) {
		TransactionStatus transtatus = transManager.getTransaction(new DefaultTransactionDefinition());
		String query = "update dept set department_name = :deptName, manager_id = :manId, location_id =  :locId  where department_id = :deptId";
		int res = 1;

		try {

			Map<String, Object> map = new HashMap<>();
			map.put("deptId", dept.getDept_id());
			map.put("deptName", dept.getDept_name());
			map.put("manId", dept.getManager_id());
			map.put("locId", dept.getLoc_id());

			namedjdbcTemp.execute(query, map, new PreparedStatementCallback<Object>() {

				@Override
				public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

					return ps.executeUpdate();
				}
			});

			transManager.commit(transtatus);
		} catch (Exception e) {
			res = 0;
			transManager.rollback(transtatus);
			System.out.println(e);
		}

		return res;
	}

	/**
	 * delete department
	 */
	public int deleteDepartment(int dept_id) {
		TransactionStatus transtatus = transManager.getTransaction(new DefaultTransactionDefinition());
		String query = "delete from dept where department_id=" + dept_id;
		int res = 0;

		try {
			res = jdbcTemp.update(query);
			transManager.commit(transtatus);
		} catch (Exception e) {
			transManager.rollback(transtatus);
			System.out.println(e);
		}
		return res;
	}
}
