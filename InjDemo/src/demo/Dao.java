package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Dao {
	
	static String url = "jdbc:mysql://localhost:3306/zoho?" + "autoReconnect=true&useSSL=false";
	static String uname = "root";
	static String pass = "mysql";
	
	public DetailModel getDet(String mobno) throws ClassNotFoundException, SQLException
	{	
		DetailModel mod = new DetailModel();
		System.out.println("Hello");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		Statement st = null;
		try {
			System.out.println("Done");
			con = DriverManager.getConnection(url, uname, pass);
			st=con.createStatement();
			System.out.println(mobno);
			ResultSet rs=st.executeQuery("select * from customer where mobno='"+mobno+"'");
			rs.next();
		//	System.out.println(rs.getString(1)+rs.getLong(2)+rs.getString(3)+rs.getInt(4));
			mod.name=rs.getString(1);
			mod.mobno=rs.getLong(2);
			mod.address=rs.getString(3);
			mod.amount=rs.getInt(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			st.close();
			con.close();
			
		}
		return mod;

	}
	
	public boolean updateDet(String mobno,int deposit) throws ClassNotFoundException, SQLException
	{
		boolean returnValue = false;
		int count;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		Statement st = null;
		try {
			con = DriverManager.getConnection(url, uname, pass);
			st=con.createStatement();
			count = st.executeUpdate("UPDATE customer SET pendingAmount=pendingAmount-'" + deposit + "' WHERE mobno='" + mobno +"'");
			System.out.println(count);
			if(count>0)
			{
				returnValue=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			st.close();
			con.close();
			
		}
		
		return returnValue;
	}
	public boolean createDet(DetailModel mod) throws ClassNotFoundException, SQLException
	{
		boolean returnValue = false;
		int count;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DriverManager.getConnection(url, uname, pass);
			st=con.prepareStatement("insert into customer values(?,?,?,?)");
	    	st.setString(1, mod.name);
	    	st.setLong(2, mod.mobno);
	    	st.setString(3, mod.address);
	    	st.setInt(4, mod.amount);
	    	count = st.executeUpdate();
	    	System.out.println(count);
			if(count>0)
			{
				returnValue=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			st.close();
			con.close();
			
		}
		
		return returnValue;
	}
	
	public boolean deleteDet(String mobno) throws ClassNotFoundException, SQLException
	{
		boolean returnValue = false;
		int count;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		Statement st = null;
		try {
			con = DriverManager.getConnection(url, uname, pass);
			st=con.createStatement();
			count = st.executeUpdate("delete from customer where mobno='" + mobno +"'");
			System.out.println(count);
			if(count>0)
			{
				returnValue=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			st.close();
			con.close();
			
		}
		
		return returnValue;
	}
	public boolean updateadd(String mobno,int deposit) throws ClassNotFoundException, SQLException
	{
		boolean returnValue = false;
		int count;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		Statement st = null;
		try {
			con = DriverManager.getConnection(url, uname, pass);
			st=con.createStatement();
			count = st.executeUpdate("UPDATE customer SET pendingAmount=pendingAmount+'" + deposit + "' WHERE mobno='" + mobno +"'");
			System.out.println(count);
			if(count>0)
			{
				returnValue=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			st.close();
			con.close();
			
		}
		
		
		
		return returnValue;
	}

}
