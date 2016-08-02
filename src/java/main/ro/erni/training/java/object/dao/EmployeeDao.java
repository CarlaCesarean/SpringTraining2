package ro.erni.training.java.object.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ro.erni.training.java.object.Employee;

public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveEmployee(Employee e) {
		String query = "insert into employee values('" + e.getId() + "','" + e.getName() + "','" + e.getSalary() + "')";
		return jdbcTemplate.update(query);
	}

	public int updateEmployee(Employee e) {
		String query = "update employee set name='" + e.getName() + "',salary='" + e.getSalary() + "' where id='"
				+ e.getId() + "' ";
		return jdbcTemplate.update(query);
	}

	public int deleteEmployee(Employee e) {
		String query = "delete from employee where id='" + e.getId() + "' ";
		return jdbcTemplate.update(query);
	}

	public List<Map<String, Object>> getEmployee(String s) {
		String query = "select * from employee where name='" + s + "' ";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(query);
		return list;
	}

	public List<Map<String, Object>> getAll() {
		String query = "select * from employee";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(query);
		return list;
	}

	public List<Employee> getEmployee2(String s) {
		String query = "select * from employee where name='" + s + "' ";
		List<Employee> list = jdbcTemplate.query(query, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet st, int rowNum) throws SQLException {

				return new Employee(st.getInt(1), st.getString(2), st.getBigDecimal(3));
			}

		});
		return list;
	}

}
