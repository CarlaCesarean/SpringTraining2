package ro.erni.training.java.object;

import java.math.BigDecimal;

public class Employee {
	private int id;
	private String name;
	private BigDecimal salary;

	public Employee() {

	}

	public Employee(int ID, String Name, BigDecimal Salary) {
		this.id = ID;
		this.name = Name;
		this.salary = Salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}
