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

import com.group1.Controllers.TradeHistoryController;
import com.group1.Models.Employee;
import com.group1.Models.Order;

/**
 * Servlet implementation class TradeHistoryServlet
 */
@WebServlet("/TradeHistoryServlet")
public class TradeHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TradeHistoryServlet() {
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
 
		TradeHistoryController tradeHistoryController = new TradeHistoryController();
		List<Order> displayList = new ArrayList<>();

			displayList = tradeHistoryController.tradeHistory(e.getEmployee_id(), e.getRole());
			request.setAttribute("displayList", displayList);
			System.out.println(e.getRole());
			if(e.getRole().equalsIgnoreCase("Trader")){
			RequestDispatcher rd=request.getRequestDispatcher("traderorderhistory.jsp");  
			rd.forward(request, response);
			}
			else if(e.getRole().equalsIgnoreCase("PM")){
			RequestDispatcher rd=request.getRequestDispatcher("pmorderhistory.jsp");  
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
