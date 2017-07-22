package com.diablo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bookservlet
 */
@WebServlet("/Bookservlet")
public class Bookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/OnlineBooks";
			String usr = "root";
			String pwd = "root";
			Connection con = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Connection established..");
			Statement stm = con.createStatement();
			/* select statement*/
			ResultSet rs = stm.executeQuery("select * from Books");
			while (rs.next())
			{
				System.out.println(rs.getString(1));
			}
			/* insert statement */
			int i = stm.executeUpdate("insert into Books values ('blackout','ken follet','sean',1990,450),('vlackout','ven follet','vean',1995,650)");
			/* update statement */
			int j = stm.executeUpdate("update Books set Price = 700 where Price = 650");
			/* delete statement */
			int k = stm.executeUpdate("delete from Books where Price = 700");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
