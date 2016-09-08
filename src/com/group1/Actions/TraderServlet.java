package com.group1.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.SortingFocusTraversalPolicy;

import org.apache.catalina.Session;
import org.json.JSONObject;

import com.group1.Controllers.TraderController;
import com.group1.Models.Employee;
import com.group1.Models.Order;
import com.group1.Models.Trader;


@WebServlet("/TraderServlet")
public class TraderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//fuck

	public TraderServlet() {
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
		System.out.println("before formatting-------------"+output);
		String[] str_array = output.split(Pattern.quote("},"));
		System.out.println("after formatting--------"+str_array.length);
		TraderController tc = new TraderController();
		HttpSession session = request.getSession();
		Employee e = (Employee)session.getAttribute("obj");
		System.out.println("session-----------"+session.getAttribute("test")+ " " + e.toString());
		
		List<Order> orders = new ArrayList<Order>();
		int pmorders=tc.getcountPM(e.getEmployee_id());
		System.out.println(pmorders);
		if(str_array.length > 1){
			if(pmorders==0)
			{
				for(int i = 0; i<str_array.length-1; i++){
				JSONObject obj = new JSONObject(str_array[i]+"}");
				Order o = new Order((Integer.valueOf((String) obj.get("Total Quantity"))),
						e.getPm_id() , e.getEmployee_id(),
						(String)obj.get("Side") , (String)obj.get("Symbol"),
						(String)obj.get("Currency"),(String)obj.get("Order Type"),
						Float.valueOf((String) obj.get("Limit Price")),
						Float.valueOf((String) obj.get("Stop Price")));
				orders.add(o);
				}
			}
			else{
			for(int i = 0; i<str_array.length-pmorders; i++){
				JSONObject obj = new JSONObject(str_array[i]+"}");
				System.out.println((String)obj.get("OrderId"));
				String orderid=(String)obj.get("OrderId");
				if(!orderid.equals("on"))
				{
					Order o = new Order((Integer.valueOf((String) obj.get("OrderId")))
							,(Integer.valueOf((String) obj.get("Total Quantity"))),
							e.getPm_id() , e.getEmployee_id(),
							(String)obj.get("Side") , (String)obj.get("Symbol"),
							(String)obj.get("Currency"),(String)obj.get("Order Type"),
							Float.valueOf((String) obj.get("Limit Price")),
							Float.valueOf((String) obj.get("Stop Price")));
					orders.add(o);
				}
				else
				{
				Order o = new Order((Integer.valueOf((String) obj.get("Total Quantity"))),
						e.getPm_id() , e.getEmployee_id(),
						(String)obj.get("Side") , (String)obj.get("Symbol"),
						(String)obj.get("Currency"),(String)obj.get("Order Type"),
						Float.valueOf((String) obj.get("Limit Price")),
						Float.valueOf((String) obj.get("Stop Price")));
				orders.add(o);
				}
			}
			}
			tc.createTraderBlockOrder(orders);

		}else {	
			JSONObject obj = new JSONObject(str_array[0]+"}");
				tc.createTraderBrokerOrder(Integer.valueOf((String) obj.get("Total Quantity")),
						e.getPm_id() , e.getEmployee_id(),
						(String)obj.get("Side") , (String)obj.get("Symbol"),
						(String)obj.get("Currency"),(String)obj.get("Order Type"),
						Float.valueOf((String) obj.get("Limit Price")),
						Float.valueOf((String) obj.get("Stop Price")));
			}	

		}

}
