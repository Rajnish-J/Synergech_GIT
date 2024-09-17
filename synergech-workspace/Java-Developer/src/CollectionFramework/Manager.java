package CollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {
	static List<Employee> employees = new ArrayList<Employee>();

	public static void main(String[] args) {
		Manager m = new Manager();

		m.storeEmployeeDetails();
		m.printEmployeeDetails();
	}

	public static void storeEmployeeDetails() {
		Employee e1 = new Employee();
		e1.setEmpID(1);
		e1.setEmpName("Rajnish");

		Employee e2 = new Employee();
		e2.setEmpID(2);
		e2.setEmpName("sabari");

		Employee e3 = new Employee();
		e3.setEmpID(3);
		e3.setEmpName("JohnSnow");

		employees.addAll(Arrays.asList(e1, e2, e3));
	}

	public static void printEmployeeDetails() {
		for (Employee obj : employees) {
			System.out.println("ID: " + obj.getEmpID());
			System.out.println("Name: " + obj.getEmpName());
			System.out.println("----------------------");
		}
	}
}
