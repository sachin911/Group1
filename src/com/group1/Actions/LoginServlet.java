package com.group1.Actions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group1.Controllers.LoginController;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Integer key;
		 String value = null;
		 int i=1;
		 String userValidity;
		 String typeOfUser;
		
		Map<Integer,String> map=new HashMap<>();
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	
	LoginController logincontroller=new LoginController();
	try {
		map=logincontroller.callLogin(username, password);
		userValidity=map.get(1);
		typeOfUser=map.get(2);
		if(userValidity.equals("Valid User") && typeOfUser.equalsIgnoreCase("PM"))
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("pmhome.html");  
			rd.forward(request, response);
		}
		if(userValidity.equals("Valid User") && typeOfUser.equalsIgnoreCase("Trader"))
		{
			 System.out.println(userValidity+typeOfUser);
			 RequestDispatcher rd=request.getRequestDispatcher("traderhome.html");  
			rd.forward(request, response);
		}
		if(userValidity.equals("Valid User") && typeOfUser.equalsIgnoreCase("Admin"))
		{
			 System.out.println(userValidity+typeOfUser);	
			 RequestDispatcher rd=request.getRequestDispatcher("adminhome.html");  
			rd.forward(request, response);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
