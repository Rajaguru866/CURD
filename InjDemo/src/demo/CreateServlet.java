package demo;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DetailModel mod = new DetailModel();
		boolean returnValue = false;
		mod.name=request.getParameter("name");
		mod.mobno=Long.parseLong(request.getParameter("mobno"));
		mod.address=request.getParameter("address");
		mod.amount=0;
		
		Dao dao = new Dao();
		try {
			returnValue = dao.createDet(mod);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(returnValue==true)
		{
			request.setAttribute("result", "Added Successfully");
		}
		else
		{
			request.setAttribute("result", "Not Added");
		}
		RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
		rd.forward(request, response);
	}

}
