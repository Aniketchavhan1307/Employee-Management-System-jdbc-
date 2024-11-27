package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCURD 
{
	public static int insertEmployee(Connection connection , Employee employee)
	{
		String sql = "insert into emp(id, name, salary, address) values (?,?,?,?)";
		
		try(PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.setInt(1, employee.getId());
			statement.setString(2, employee.getName());
			statement.setDouble(3, employee.getSal());
			statement.setString(4, employee.getAddress());
			
			 return statement.executeUpdate(); 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public static List<Employee> fetchAllEmployee(Connection connection)
	{
		String sql = "select * from emp";
		
		List<Employee> employees = new ArrayList<>();
		
		try (PreparedStatement statement= connection.prepareStatement(sql))
		{
			ResultSet set= statement.executeQuery();
			while (set.next())
			{
				int id= set.getInt("id");
				String name = set.getString("name");
				double sal = set.getDouble("salary");
				String address = set.getString("address");
				
				employees.add(new Employee(id,name,sal,address));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return employees;
	}

	public static int deleteEmployee(Connection connection,int id) 
	{
		String sql = "delete from emp where id =?";
		
		try (PreparedStatement statement = connection.prepareStatement(sql))
		{
			statement.setInt(1, id);
			return statement.executeUpdate();
			
		} 
		catch (Exception e) 
		{
			return 0;
		}
	}

	public static int updateEmployeeSalary(Connection connection, int id, double newSalary) 
	{
		String sql = "update emp set salary = ? where id = ?";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql))
		{
            preparedStatement.setDouble(1, newSalary);
            preparedStatement.setInt(2, id);
           return preparedStatement.executeUpdate();
        }
		catch (Exception e) 
		{
			e.printStackTrace();
			return 0;
		}
		
	}

}
