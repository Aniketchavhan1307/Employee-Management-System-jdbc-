package employee;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) 
	{
		
		System.out.println("hello");
		
		try (Connection connection = DB_Connection.getConnection())
		{
			Scanner scanner = new Scanner(System.in);

			System.out.println("Choose an option");

			boolean running = true;

			while (running) {
				displayMenu();

				int choose = scanner.nextInt();

				switch (choose) {
				case 1: 
				{
					System.out.println("Enter employee id");
					int id = scanner.nextInt();

					System.out.println("Enter employee name");
					String name = scanner.next();

					System.out.println("Enter employee sal");
					double sal = scanner.nextDouble();

					System.out.println("Enter employee address");
					String address = scanner.next();

					Employee employee = new Employee(id, name, sal, address);

					int save = EmployeeCURD.insertEmployee(connection, employee);

					if (save > 0) {
						System.out.println("Employee data has been saved successfully");
					} else {
						System.out.println("Employee data has failed to saved due to save error");
						System.out.println("give valid credentials");

					}

					break;
				}
				
				case 2:
					List<Employee> employees = EmployeeCURD.fetchAllEmployee(connection);
					System.out.println("Employee List: ");
					for (Employee employee : employees) 
					{
						System.out.println("====================================== " );
						System.out.println("id : " + employee.getId());
						System.out.println("name : " + employee.getName());
						System.out.println("sal : " + employee.getSal());
						System.out.println("address : " + employee.getAddress());
						System.out.println("====================================== " );
					}
					
					break;
					
				case 3:
					 System.out.print("Enter employee ID to update salary: ");
                     int updateId = scanner.nextInt();
                     
                     System.out.print("Enter new salary: ");
                     double newSalary = scanner.nextDouble();
                     
                  int update = EmployeeCURD.updateEmployeeSalary(connection, updateId, newSalary);
                     
                     if (update>0) 
 					{
                         System.out.println("Employee salary updated successfully!");
 					} else 
 					{
 						System.out.println("Employee failed to update");

 					}
 					break;
					
				case 4: 
					System.out.println("Enter employee id ");
					int id = scanner.nextInt();
					
					int delete = EmployeeCURD.deleteEmployee(connection, id);

					if (delete>0) 
					{
						System.out.println("Employee deleted successfully");
					} else 
					{
						System.out.println("Employee failed deleted");

					}
					break;
					
					
					
				case 5:
                    System.out.println("Exiting application...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    
				}

			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

	private static void displayMenu() {

		System.out.println("\nEmployee Management System");
		System.out.println("1. Add Employee");
		System.out.println("2. Fetch All Employees");
		System.out.println("3. Update Employee Salary");
		System.out.println("4. Delete Employee");
		System.out.println("5. Exit");
	}

}
