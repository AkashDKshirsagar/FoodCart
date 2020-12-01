package com.akash.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akash.bean.Food;
import com.akash.dao.FoodDAO;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FoodDAO foodDAO;
	private static String LIST_ITEM = "/foodCart.jsp";
	
	public void init()
	{
		String URL = getServletContext().getInitParameter("URL");
		String Username = getServletContext().getInitParameter("Username");
		String Password = getServletContext().getInitParameter("Password");
		
		foodDAO = new FoodDAO(URL,Username,Password);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String forward = " ";
		String action = request.getParameter("action");
		try {
			List<Food> foodItems = FoodDAO.listAllFood();
			System.out.println(foodItems.size());
			forward = LIST_ITEM;
			request.setAttribute("foodItems", foodItems);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
}
