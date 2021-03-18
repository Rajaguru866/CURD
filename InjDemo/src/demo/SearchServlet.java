package demo;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mobno=request.getParameter("mobno");
		DetailModel mod=null;
		Dao dao=new Dao();
		try {
			mod=dao.getDet(mobno);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mod.name+"   "+ mod.mobno+"    "+mod.address+"    "+mod.amount);
		HttpSession session = request.getSession();
		session.setAttribute("mobno", mobno);
		session.setAttribute("amount", mod.amount);
		request.setAttribute("name", mod.name);
		request.setAttribute("address", mod.address);
		RequestDispatcher rd=request.getRequestDispatcher("ShowCustomer.jsp");
		rd.forward(request, response);
		//response.sendRedirect("Login.jsp");
		
	}

}
