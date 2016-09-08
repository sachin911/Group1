package com.group1.Actions;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group1.Controllers.MessageController;
import com.group1.Models.Employee;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Employee e = null;
		int senderid;
		HttpSession session = request.getSession();
		e = (Employee) session.getAttribute("obj");
		senderid = e.getEmployee_id();

		String receivername = request.getParameter("user");
		String message = request.getParameter("message");
		System.out.println("usr ------" + receivername);
		System.out.println("sender ------" + senderid);

		MessageController msg = new MessageController();
		try {
			msg.messageservice(receivername, senderid, message);
			RequestDispatcher rd = request.getRequestDispatcher("PMHomeServlet");

			rd.forward(request, response);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

}
