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

import com.sprinmvc.SpringMvc.utilities.EmpModel;

@Component
public class EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedjdbctemp;

	@Autowired
	PlatformTransactionManager transManager;

	@Autowired
	EmpModel emp;

	/**
	 * get all employee
	 */
	public List<EmpModel> getAllEmployees() {

		List<EmpModel> list = new ArrayList<>();

		String query = "select * from emp";

		list = jdbcTemplate.query(query, new EmployeeMapper());

		return list;
	}

	/**
	 * get one employee
	 */
	public EmpModel getEmplyee(int id) {
		String query = "select * from emp where employee_id=" + id;

		emp = (EmpModel) jdbcTemplate.queryForObject(query, new EmployeeMapper());

		return emp;
	}

	/**
	 * add employee
	 */
	public int addEmployee(EmpModel emp) {

		TransactionStatus transStatus = transManager.getTransaction(new DefaultTransactionDefinition());
		String query = "insert into emp(employee_id, first_name,job_id,salary) values(:id, :name, :jobid, :sal)";
		int res = 1;

		try {

			Map<String, Object> map = new HashMap<>();
			map.put("id", emp.getEmp_id());
			map.put("name", emp.getFname());
			map.put("jobid", emp.getJob_id());
			map.put("sal", emp.getSal());

			namedjdbctemp.execute(query, map, new PreparedStatementCallback<Object>() {

				@Override
				public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

					return ps.executeUpdate();

				}
			});

			transManager.commit(transStatus);
		} catch (Exception e) {
			res = 0;
			transManager.rollback(transStatus);
			System.out.println(e);
		}

		return res;
	}

	/**
	 * update employee
	 */
	public int updateEmployee(EmpModel emp) {

		TransactionStatus transStatus = transManager.getTransaction(new DefaultTransactionDefinition());
		String query = "update emp set first_name=:name, job_id=:jobid, salary=:sal where employee_id=:id";
		int res = 1;

		try {

			Map<String, Object> map = new HashMap<>();
			map.put("id", emp.getEmp_id());
			map.put("name", emp.getFname());
			map.put("jobid", emp.getJob_id());
			map.put("sal", emp.getSal());

			namedjdbctemp.execute(query, map, new PreparedStatementCallback<Object>() {

				@Override
				public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

					return ps.executeUpdate();

				}
			});
			transManager.commit(transStatus);
		} catch (Exception e) {
			res = 0;
			transManager.rollback(transStatus);
			System.out.println(e);
		}

		return res;
	}

	/**
	 * delete one employee
	 */
	public int deleteEmployee(int id) {
		TransactionStatus transStatus = transManager.getTransaction(new DefaultTransactionDefinition());
		String query = "delete from emp where employee_id=" + id;
		try {

			int res = jdbcTemplate.update(query);
			transManager.commit(transStatus);
			return res;

		} catch (Exception e) {
			transManager.rollback(transStatus);
			System.out.println(e);
		}

		return 0;
	}

}
