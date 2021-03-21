package demo;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AddAmountServlet
 */
public class AddAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddAmountServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String mobno =(String) session.getAttribute("mobno");
		String amountstr = request.getParameter("deposit");
		int amount = Integer.parseInt(amountstr);
		Dao dao = new Dao();
		System.out.println(mobno+"********");
	    boolean returnValue = false;
		try {
			returnValue = dao.updateadd(mobno, amount);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(returnValue==true)
		{
			request.setAttribute("result", "Updated Successfully");
			System.out.println("Updated");
		}
		else
		{
			request.setAttribute("result", "Update Failed");
			System.out.println("not updated");
		}
		session.removeAttribute(mobno);
		RequestDispatcher rd=request.getRequestDispatcher("Result.jsp");
		rd.forward(request, response);
	}


}
