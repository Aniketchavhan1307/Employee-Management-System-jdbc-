package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection 
{
	private static final String dbUrl = "jdbc:mysql://localhost:3306/EmployeeJDBC";
	private static final String user = "root";
	private static final String pass = "root";
	

	private static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection(dbUrl,user,pass);
	}
}
