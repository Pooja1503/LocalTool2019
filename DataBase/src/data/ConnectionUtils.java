package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



public class ConnectionUtils {
	
	public static Connection getConnection() throws IOException  {
		
		FileInputStream fis = new FileInputStream("E:\\config.properties.txt");
		
		Properties properties = new Properties();
		properties.load(fis);
		
		String DBUser = properties.getProperty("dbuser");
		String DBPass = properties.getProperty("dbpassword");
		System.out.println(DBUser);
		System.out.println(DBPass);
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/southwind",DBUser,DBPass);
			
			System.out.println("Connected to DB");
		}
		catch (Exception e) {
			
			System.out.println("Connected Failed");
		}
		return con;
	}
	

	public static void main(String[] args) throws IOException {
		
		ConnectionUtils.getConnection();
		
	}

}
