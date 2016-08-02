package ro.erni.training.java.object;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.erni.training.java.object.dao.EmployeeDao;

public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeDao dao = (EmployeeDao) ctx.getBean("edao");
		// int status = dao.saveEmployee(new Employee(102, "Amit", new
		// BigDecimal("3500.0")));
		// int status = dao.getEmployee("Amit");
		// int status2 = dao.getAll();
		// System.out.println(status);
		// System.out.println(status2);

		for (Map<String, Object> row : dao.getEmployee("Amit")) {
			System.out.println(row.get("id") + " " + row.get("name") + " " + row.get("salary"));
		}

		System.out.println("\n\nBLA BLA..SPATIU DRAMATIC\n\n");

		for (Map<String, Object> row : dao.getAll()) {
			System.out.println(row.get("id") + " " + row.get("name") + " " + row.get("salary"));
		}
		System.out.println("\n\nBLA BLA..SPATIU DRAMATIC\n\n");

		List<Employee> list = dao.getEmployee2("Amit");
		for (Employee employee : list) {
			System.out.println(employee.getName());
		}

		/*
		 * int status=dao.updateEmployee(new Employee(102,"Sonoo",15000));
		 * System.out.println(status);
		 */

		/*
		 * Employee e=new Employee(); e.setId(102); int
		 * status=dao.deleteEmployee(e); System.out.println(status);
		 */

	}

}
