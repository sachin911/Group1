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

import com.group1.Controllers.PLController;
import com.group1.Models.Employee;
import com.group1.Models.Order;

/**
 * Servlet implementation class PLServlet
 */
@WebServlet("/PLServlet")
public class PLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Employee e = (Employee) session.getAttribute("obj");
		System.out.println("e" + e.getEmployee_id());
		
		PLController plController = new PLController();
		List<Order> displayPlList = new ArrayList<>();
		displayPlList = plController.PLCalculation(e.getEmployee_id(), e.getRole());
		request.setAttribute("displayPlList", displayPlList);
		System.out.println(e.getRole());
		if(e.getRole().equalsIgnoreCase("Trader")){
		RequestDispatcher rd=request.getRequestDispatcher("tradeprofitloss1.jsp");  
		System.out.println(displayPlList);
		rd.forward(request, response);
		}
		else if(e.getRole().equalsIgnoreCase("PM")){
		RequestDispatcher rd=request.getRequestDispatcher("pmprofitloss1.jsp");  
		rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
