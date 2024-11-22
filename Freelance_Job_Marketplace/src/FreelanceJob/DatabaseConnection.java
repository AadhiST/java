package FreelanceJob;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class DatabaseConnection {
		// TODO Auto-generated method stub
		private static final String URL = "jdbc:mysql://localhost:3306/FREELANCEJOB";
		private static final String USER = "root";
		private static final String PASSWORD = "#ihdaa01#";		
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
	public static void testconnection()
	{
		try(Connection com = getConnection())
		{
			if(com!=null)
			{
				System.out.println("Database connected successfully");
			}
			else
			{
				System.out.println("Database connection failed");

			}
		}
		catch(SQLException e)
		{
			System.out.println("Database connection failed");
			e.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		testconnection();
	}
}
