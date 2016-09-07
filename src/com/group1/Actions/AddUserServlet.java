package com.group1.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group1.Controllers.AdminController;
import com.group1.Models.Employee;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String pm_idStr = request.getParameter("pm_id");
		
		int pm_id = Integer.parseInt(pm_idStr);
		
//		e.setFirst_Name(first_name);
//		e.setLast_Name(last_name);
//		e.setUserName(username);
//		e.setPassword(password);
//		e.setRole(role);
//		
//		if (role.equals("Trader")) {
//			e.setPm_id(pm_id);
//		}

		AdminController ac = new AdminController();
		boolean result = ac.AddAdminController(username, password, first_name, last_name, role, pm_id);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
