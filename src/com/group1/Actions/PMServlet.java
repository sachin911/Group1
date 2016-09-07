package com.group1.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.group1.Controllers.TraderController;
import com.group1.Models.Employee;
import com.group1.Models.Order;


@WebServlet("/PMServlet")
public class PMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public PMServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String order_arr = request.getParameter("tab_val");
		//System.out.println(order_arr);
		String output = null;
		output = order_arr.replace("[", "").replace("]", "").replace("{},", "").replace(",{\"\":\"on\"}", "");
		System.out.println(output);
		String[] str_array = output.split(Pattern.quote("},"));
		TraderController tc = new TraderController();
		HttpSession session = request.getSession();
		Employee e = (Employee)session.getAttribute("obj");
		System.out.println("session-----------"+session.getAttribute("test")+ " " + e.toString());

		JSONObject obj = new JSONObject(str_array[0]+"}");
		
		
		tc.createTraderBokerOrder(Integer.valueOf((String) obj.get("Total Quantity")),
				e.getPm_id() , e.getEmployee_id(),
				(String)obj.get("Side") , (String)obj.get("Symbol"),
				(String)obj.get("Currency"),(String)obj.get("Order Type"),
				Float.valueOf((String) obj.get("Limit Price")),
				Float.valueOf((String) obj.get("Stop Price")));	

	}		
}
