package demo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		if(uname.equals("admin") && pass.equals("me"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("pass", pass);
			response.sendRedirect("Admin.jsp");
		}
		else
		{
			response.sendRedirect("Login.jsp");
		}
	}

}
