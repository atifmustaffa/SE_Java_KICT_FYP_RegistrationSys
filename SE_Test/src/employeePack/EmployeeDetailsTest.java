package employeePack;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeDetailsTest extends EmployeeLogic {

	@Test
	public void test() {
		EmployeeDetails employee1 = new EmployeeDetails();
		employee1.setName("Azfar");
		employee1.setMonthlySalary(10300);
		employee1.setAge(21);
		
		EmployeeDetails employee2 = new EmployeeDetails();
		employee2.setName("HazimJoker");
		employee2.setMonthlySalary(2300);
		employee2.setAge(21);
		
		System.out.println("Name: " + employee1.getName() + "\n"
				+ "Age: " + employee1.getAge() + "\n"
				+ "Monthly Salary: " + employee1.getMonthlySalary() + "\n"
				+ "Yearly Salary: " + calculateYearlySalary(employee1) + "\n"
				+ "Appraisal: " + calculateAppraisal(employee1));
		
		System.out.println("\n\nName: " + employee2.getName() + "\n"
				+ "Age: " + employee2.getAge() + "\n"
				+ "Monthly Salary: " + employee2.getMonthlySalary() + "\n"
				+ "Yearly Salary: " + calculateYearlySalary(employee2) + "\n"
				+ "Appraisal: " + calculateAppraisal(employee2));
	}

}
