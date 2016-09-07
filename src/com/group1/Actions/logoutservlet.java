package com.group1.Actions;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logoutservlet
 */
@WebServlet("/logoutservlet")
public class logoutservlet extends HttpServlet implements Filter {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logoutservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doFilter(request, response, null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
        
        //if(session.getAttribute("obj")!=null)
               
               ((HttpServletRequest) req).getSession().invalidate();
              ((HttpServletResponse) res).sendRedirect(((HttpServletRequest) req).getContextPath() + "/login.jsp");

        // response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
       // response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        // response.setDateHeader("Expires", 0); // Proxies.

        
   
        
       //  ((HttpServletResponse) res).sendRedirect(((HttpServletRequest) req).getContextPath() + "/login.jsp");
        
       // chain.doFilter(req, res);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
