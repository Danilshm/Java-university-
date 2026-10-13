package employeecomparator;

public class EmployeeRegisterDemo {

	public static void main(String[] args) {
		var reg = new EmployeeRegister("Finance");
		
		reg.addEmployee(new Employee(new Name("Tom", "Ford"), new Date(5,5,2013), 15500.50));
		reg.addEmployee(new Employee(new Name("Anna", "Holdon"), new Date(1,3,2009), 10000));
		reg.addEmployee(new Employee(new Name("Katie", "Wood"), new Date(4,1,2010), 25000.50));
		reg.addEmployee(new Employee(new Name("Dharmesh", "Palal"), new Date(1,12,2012), 12000));
		
		
		System.out.println("List of employees:");
		for (Employee e : reg) {
			System.out.print(e.getName().getFullName() + " -- Salary is " + e.getSalary() + " -- Start date: " + e.getStartDate().getDateString() + "\n");
		}
		
		
	}

}
