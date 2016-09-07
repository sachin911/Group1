package com.group1.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group1.Controllers.PLController;
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
		
		
		Random rand = new Random();float current_price, current_assets = 0, pl_assets = 0, executed_assets = 0;
		
		
		HttpSession session = request.getSession();
		Employee e = (Employee) session.getAttribute("obj");
		System.out.println("e" + e.getEmployee_id());
		
		PLController plController = new PLController();
		List<Order> displayPlList = new ArrayList<>();
		displayPlList = plController.PLCalculation(e.getEmployee_id(), e.getRole());
		System.out.println(displayPlList);
		
		for(int i =0;i<displayPlList.size();i++){
			
			current_price = (float)((displayPlList.get(i).getExecuted_price() + rand.nextDouble()*15) - 5);
			current_assets += current_price * displayPlList.get(i).getOpen_quantity();
			executed_assets += displayPlList.get(i).getExecuted_price() * displayPlList.get(i).getOpen_quantity();
			pl_assets += (displayPlList.get(i).getExecuted_price() - current_price) * displayPlList.get(i).getOpen_quantity();
			
		}
		float change = pl_assets/executed_assets;
		
		request.setAttribute("current_assets", current_assets);
		request.setAttribute("pl_assets", pl_assets);
		request.setAttribute("change", change);
		
		
		RequestDispatcher rd=request.getRequestDispatcher("pmhome1.jsp");
		TraderController tr =  new TraderController();
		int ta = tr.getTotalAssets(e.getEmployee_id());
		int pl = tr.getPL(e.getEmployee_id());
		request.setAttribute("pl", pl);
		request.setAttribute("totalassets", ta);
		ArrayList<Order> ol = new ArrayList<Order>();
		ol=tr.getlist(e.getEmployee_id());
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
