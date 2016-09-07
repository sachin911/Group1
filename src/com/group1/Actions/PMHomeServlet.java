package com.group1.Actions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group1.Controllers.TraderController;
import com.group1.Models.Employee;
import com.group1.Models.Order;

/**
 * Servlet implementation class PMHomeServlet
 */
@WebServlet("/PMHomeServlet")
public class PMHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PMHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee e = (Employee) session.getAttribute("obj");
		System.out.println("e" + e.getEmployee_id());
		
		RequestDispatcher rd=request.getRequestDispatcher("pmhome1.jsp");
		TraderController tr =  new TraderController();
		int ta = tr.getTotalAssets(e.getEmployee_id());
		int pl = tr.getPL(e.getEmployee_id());
		session.setAttribute("pl", pl);
		session.setAttribute("totalassets", ta);
		ArrayList<Order> ol = new ArrayList<Order>();
		ol=tr.getlist(e.getEmployee_id());
		session.setAttribute("ol", ol);
response.sendRedirect("pmhome1.jsp");

		//rd.forward(request, response);
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
