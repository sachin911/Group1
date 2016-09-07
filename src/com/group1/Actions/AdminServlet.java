package com.group1.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group1.Controllers.AdminController;
import com.group1.Controllers.TraderController;
import com.group1.Models.Employee;
import com.group1.Models.Order;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee e = (Employee) session.getAttribute("obj");
		System.out.println("e" + e.getEmployee_id());
		
		RequestDispatcher rd=request.getRequestDispatcher("adminhome1.jsp");
		AdminController ac = new AdminController();
		List<Employee> el=new ArrayList<Employee>();
		el = ac.getAllEmployees();
		session.setAttribute("el", el);

response.sendRedirect("adminhome1.jsp");
		//rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
