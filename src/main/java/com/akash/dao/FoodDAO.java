package com.akash.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.akash.bean.Food;

public class FoodDAO {
	private static String URL = "";
	private static String Username = "";
	private static String Password = "";
	private static Connection con;
	
	public FoodDAO(String URL, String Username, String Password)
	{
		this.URL = URL;
		this.Username = Username;
		this.Password = Password;
	}
	public static void connect() throws ClassNotFoundException, SQLException {
		if (con == null || con.isClosed()) {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, Username, Password);
			System.out.println("Database Connected...");
		}
	}

	public static void disconnect() throws SQLException {
		if(con != null && !con.isClosed())
			con.close();
	}
	
	public static List<Food> listAllFood() throws ClassNotFoundException, SQLException
	{
		List<Food> listFood = new ArrayList<Food>();
		String sql = "select * from world.food";
		connect();
		
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		while(rs.next())
		{
			int code = rs.getInt(1);
			String item = rs.getString(2);
			float price = rs.getFloat(3);
			
			Food fd = new Food();
			fd.setCode(code);
			fd.setItem(item);
			fd.setPrice(price);
			
			listFood.add(fd);
		}
		s.close();
		rs.close();
		disconnect();
		return listFood;
	}

}
