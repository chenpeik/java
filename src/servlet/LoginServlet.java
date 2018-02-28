package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class LoginServlet extends HttpServlet{
	String url = "jdbc:mysql://localhost:3306/day17";
	String username = "root";
	String password = "root";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html;charset=utf-8");
		
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			Statement statement = null;
			ResultSet rs = null;
			System.out.println(name);
			String sql = "select * from student where id ="+id+" and name ="+name;
			conn = (Connection) DriverManager.getConnection(url, username, password);
			statement = (Statement) conn.createStatement();
			rs = statement.executeQuery(sql);
			if(rs.next()){
				resp.getWriter().write("µÇÂ¼³É¹¦");
			}else{
				resp.getWriter().write("µÇÂ¼Ê§°Ü");
			}
			statement.close();	
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				
		}
		
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		this.doGet(req, resp);
	}
}
