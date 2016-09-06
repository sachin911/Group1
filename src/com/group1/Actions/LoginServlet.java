package com.group1.Actions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group1.Controllers.LoginController;
import com.group1.Models.Employee;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 10L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/*
	 * int eid; int pmid; String pass; int attempts; String role;
	 * 
	 * public LoginServlet(String username, String pass2, int attempts2, String
	 * role2, int eid2, int pmid2) {
	 * 
	 * this.pass = pass2; this.attempts = attempts2; this.role = role2; this.eid
	 * = eid2; this.pmid = pmid2;
	 * 
	 * }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer key;
		String value = null;

		String userValidity;
		String typeOfUser;
		int eid;
		Employee e = null;
		Map<Integer, String> map = new HashMap<>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		List<Object> li = new ArrayList<>();
		Object obj=new Object();

		LoginController logincontroller = new LoginController();
		try {
			li = logincontroller.callLogin(username, password);
			map = (Map<Integer, String>) li.get(0);
			
             System.out.println(li.size());
			userValidity = map.get(1);
			typeOfUser = map.get(2);
			// eid=Integer.parseInt(map.get(3));
			if(userValidity.equals("Valid User")){
				e=(Employee) li.get(1);
			}
			
			
			if (userValidity.equals("Valid User")
					&& typeOfUser.equalsIgnoreCase("PM")) {
				HttpSession session = request.getSession();
				session.setAttribute("obj", e);
			System.out.println(obj);
				RequestDispatcher rd = request
						.getRequestDispatcher("pmhome.html");
				rd.forward(request, response);
			}
			if (userValidity.equals("Valid User")
					&& typeOfUser.equalsIgnoreCase("Trader")) {
				System.out.println(userValidity + typeOfUser);
				HttpSession session = request.getSession();
				session.setAttribute("obj", e);
			System.out.println(obj);
				RequestDispatcher rd = request
						.getRequestDispatcher("traderhome.html");
				rd.forward(request, response);
			}
			if (userValidity.equals("Valid User")
					&& typeOfUser.equalsIgnoreCase("Admin")) {
				System.out.println(userValidity + typeOfUser);
				HttpSession session = request.getSession();
				session.setAttribute("obj", e);
			System.out.println(obj);
				RequestDispatcher rd = request
						.getRequestDispatcher("adminhome.html");
				rd.forward(request, response);
			}
			if (userValidity.equals("Invalid password")
					&& typeOfUser.equalsIgnoreCase("null")) {
				System.out.println(userValidity + typeOfUser);
				request.setAttribute("error", "Invalid Username/Password");
				RequestDispatcher rd = request
						.getRequestDispatcher("Login1.jsp");

				rd.forward(request, response);
			}
			if (userValidity.equals("block account")
					&& typeOfUser.equalsIgnoreCase("null")) {
				// System.out.println(userValidity+typeOfUser);
				// request.setAttribute("buttondisable", true);
				request.setAttribute("error",
						"Your account is blocked, Contact admin to activate");
				RequestDispatcher rd = request
						.getRequestDispatcher("Login1.jsp");
				rd.forward(request, response);
			}
			if (userValidity.equals("Invalid user")
					&& typeOfUser.equalsIgnoreCase("null")) {
				// System.out.println(userValidity+typeOfUser);

				RequestDispatcher rd = request
						.getRequestDispatcher("Login1.jsp");
				request.setAttribute("error", "Invalid Username/Password");
				rd.forward(request, response);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();

		}
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
