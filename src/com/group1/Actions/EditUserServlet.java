package com.group1.Actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group1.Controllers.AdminController;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String pm_idStr="";
		int pm_id=0;
		if(request.getParameter("pm_id")!=null)
		{
			pm_idStr = request.getParameter("pm_id");
			 pm_id = Integer.parseInt(pm_idStr);

		
		}
System.out.println(first_name + " " +username+" "+role+" "+pm_idStr);

System.out.println(pm_id);
		AdminController ac = new AdminController();
		boolean result = ac.EditAdminController(username, password, first_name, last_name, role, pm_id);
		System.out.println(result);
		response.sendRedirect("AdminServlet");
		response.getWriter().append("Served at: ").append(request.getContextPath());		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
