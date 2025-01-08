package com.example.myapp.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.myapp.hr.model.Emp;

@Repository
public class EmpRepository implements IEmpRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int getEmpCount() {
		String sql = "SELECT COUNT(*) FROM employees";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int getEmpCount(int deptid) {
		String sql = "SELECT COUNT(*) FROM employees WHERE department_id = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, deptid);
	}

	@Override
	public List<Map<String, Object>> getEmpListMap() {
		String sql = "SELECT employee_id, first_name, last_name, email, phone_number, "
				+ "hire_date, job_id, salary, commission_pct, manager_id, department_id "
				+ "FROM employees";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public Map<String, Object> getEmpInfoMap(int empid) {
		String sql = "SELECT employee_id, first_name, last_name, email, phone_number, "
				+ "hire_date, job_id, salary, commission_pct, manager_id, department_id "
				+ "FROM employees WHERE employee_id = ?";
		return jdbcTemplate.queryForMap(sql, empid);
	}

	@Override
	public void updateEmp(Emp emp) {
		String sql = "UPDATE employees "
				+ "SET first_name=?, last_name=?, email=?, phone_number=?, hire_date=?, "
				+ "job_id=?, salary=?, commission_pct=?, manager_id=?, department_id=? "
				+ "WHERE employee_id=?";
		jdbcTemplate.update(sql, emp.getFirstName(),
								 emp.getLastName(),
								 emp.getEmail(),
								 emp.getPhoneNumber(),
								 emp.getHireDate(),
								 emp.getJobId(),
								 emp.getSalary(),
								 emp.getCommissionPct(),
								 emp.getManagerId(),
								 emp.getDepartmentId(),
								 emp.getEmployeeId());
	}

	@Override
	public void insertEmp(Emp emp) {
		String sql = "INSERT INTO employees VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, emp.getEmployeeId(),
								 emp.getFirstName(),
								 emp.getLastName(),
								 emp.getEmail(),
								 emp.getPhoneNumber(),
								 emp.getHireDate(),
								 emp.getJobId(),
								 emp.getSalary(),
								 emp.getCommissionPct(),
								 emp.getManagerId(),
								 emp.getDepartmentId());
	}

	@Override
	public void deleteJobHistory(int empid) {
		String sql = "DELETE FROM job_history WHERE employee_id=?";
		jdbcTemplate.update(sql, empid);
	}

	@Override
	public int deleteEmp(int empid, String email) {
		String sql = "DELETE FROM employees WHERE employee_id=? AND email=?";
		int rowCount = jdbcTemplate.update(sql, empid, email);
		if (rowCount == 0) {
			throw new RuntimeException("사원번호와 이메일이 다릅니다.");
		}
		return rowCount;
	}

	@Override
	public List<Map<String, Object>> getAllDeptId() {
		String sql = "SELECT department_id, department_name FROM departments";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getAllJobId() {
		String sql = "SELECT job_id, job_title FROM jobs";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getAllManagerId() {
		String sql = "SELECT d.manager_id, e.first_name || ' ' || e.last_name as name "
				+ "FROM departments d "
				+ "JOIN employees e ON d.manager_id=e.employee_id "
				+ "ORDER BY d.manager_id";
		return jdbcTemplate.queryForList(sql);
	}
	
	private class EmpMapper implements RowMapper<Emp> {
		@Override
		public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
			Emp emp = new Emp();
			emp.setEmployeeId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
			return emp;
		}
	}
	
	@Override
	public List<Emp> getEmpList() {
		String sql = "SELECT * FROM employees";
		return jdbcTemplate.query(sql, new EmpMapper());
	}

	@Override
	public Emp getEmpInfo(int empid) {
		String sql = "SELECT * FROM employees WHERE employee_id=?";
		return jdbcTemplate.queryForObject(sql, new EmpMapper(), empid);
	}

}
