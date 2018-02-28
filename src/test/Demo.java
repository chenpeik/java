package test;

import java.sql.DriverManager;
import java.sql.ResultSet;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Demo {
	String url = "jdbc:mysql://localhost:3306/day17";
	String username = "root";
	String password = "root";
	@Test
	public void login() throws Exception{
		int id = 2;
		String name = "111";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		Statement statement = null;
		
		try {
			String sql = "select * from student";
			conn = (Connection) DriverManager.getConnection(url, username, password);
			statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				
				System.out.println(rs.getInt(1)+"success"+rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			statement.close();
			conn.close();
		}
	}
}
