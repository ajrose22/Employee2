import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Unregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Unregister() {
        // TODO Auto-generated constructor stub
    }

    											//19082
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //1. Get the data from the front end
	 String name=request.getParameter("name");
	 String email=request.getParameter("email");
	 int phoneno=Integer.parseInt(request.getParameter("phoneno"));
	 int id =Integer.parseInt(request.getParameter("id"));
	 
	 //2. Set the data to the bean
	 EmpBean emp=new EmpBean();
	 emp.setEmpname(name);
	 emp.setEmpemail(email);
	 emp.setEmpphone(phoneno);
	 emp.setID(id);
	 
	 
	 //3.Establish connection with the DB and insert my data
	 PrintWriter pw=response.getWriter();
	 try {
		EmpDAO dao=new EmpDAO();
		int status=dao.insert(emp);
		if(status>0) {
			System.out.println(status + "insertion is successful");
			RequestDispatcher rd=request.getRequestDispatcher("RegisterDemo"); 
			request.setAttribute("empobj", emp);
			rd.forward(request,response);
		}
		else {
			pw.print(status + "insertion is not successful");
	 }
		
			
			
			
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 
	pw.close();

	 
	
	}
	

}