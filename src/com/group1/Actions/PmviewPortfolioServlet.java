package com.group1.Actions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group1.Controllers.PmtradeController;
import com.group1.Controllers.PmviewPortfolioController;
import com.group1.Models.Employee;

/**
 * Servlet implementation class PmviewPortfolioServlet
 */
@WebServlet("/PmviewPortfolioServlet")
public class PmviewPortfolioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PmviewPortfolioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int pid;
		int i;
		String trader=(String) request.getParameter("uname");
		PmviewPortfolioController pc=new PmviewPortfolioController();
		System.out.println("trader is "+ trader);
		HttpSession session = request.getSession();
		Employee e = (Employee) session.getAttribute("obj");
		pid=e.getEmployee_id();
		List<Object> li=new ArrayList<>();
		//HashSet<String> set = new HashSet<>(values);

		
		li=pc.callviewPortfoliocontroller(trader,pid);		
		
		for( i=0;i<li.size();i++)
		{
			//System.out.println("=============inside pmtraderServlet>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(li.get(i));
		}
		RequestDispatcher rd = request.getRequestDispatcher("pmtraderviewportfolio.jsp");

		request.setAttribute("li", li);
		rd.forward(request, response);
		li=null;
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
		
		
		// TODO Auto-generated method stub
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
