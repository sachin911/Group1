package com.group1.Actions;
import com.group1.Controllers.*;
import com.group1.Models.Employee;
import com.group1.Models.Order;

import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TraderHomeServlet
 */
@WebServlet("/TraderHomeServlet")
public class TraderHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TraderHomeServlet() {
		super();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Employee e = (Employee) session.getAttribute("obj");
		System.out.println("e" + e.getEmployeeId());
		
		RequestDispatcher rd=request.getRequestDispatcher("traderhome1.jsp");
		TraderController tr =  new TraderController();
		int ta = tr.getTotalAssets(e.getEmployeeId());
		int pl = tr.getPL(e.getEmployeeId());
		request.setAttribute("pl", pl);
		request.setAttribute("totalassets", ta);
		ArrayList<Order> ol=new ArrayList<Order>();
		ol=tr.getlist(e.getEmployeeId());
		request.setAttribute("ol", ol);


		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
