package com.ksquareit.jsp;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserSelection
 */
@WebServlet(description = "Servlets to process UserSelection", urlPatterns = { "/UserSelection" })
public class UserSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection conObj = null; 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			conObj = DBUtil.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}//Database connection checking.
		
		String temp = request.getParameter("cofname");
		if(temp.equals("None")){
			//Do Nothing 
		}else if(temp.equals("All")){
			ArrayList<Coffee> cofList = new ArrayList<Coffee>();
			try {
				cofList = DBUtil.testAll(conObj);
				request.setAttribute("coffeelist", cofList);
				String address1 = "DisplayAllCoffee.jsp";	    
			    RequestDispatcher dispatcher = request.getRequestDispatcher(address1);
			    dispatcher.forward(request, response);			
			} catch (SQLException e) {
				e.printStackTrace();
			}						
		}else{//For each coffee from the list
			System.out.println(request.getParameter("cofname"));
			Coffee cofObj1 = null;
			try {
				cofObj1 = DBUtil.test(temp,conObj);
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
			request.setAttribute("coffee", cofObj1);
			String address = "DisplayCoffee.jsp";	    
		    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		    dispatcher.forward(request, response);			
		}//end of else
		
	}//end of doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
