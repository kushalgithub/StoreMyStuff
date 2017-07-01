package controller_pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao_pkg.docs_dao;
import dao_pkg.login_dao;
import model_pkg.Reg_model;
import model_pkg.documents_model;
import model_pkg.login_model;

/**
 * Servlet implementation class login
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
		
	 private static final long serialVersionUID = 1L;

	    public void doPost(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  

	    	System.out.println("abcd");
	    	
	    	HttpSession session = request.getSession();
	        response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	        login_model lm = new login_model();
	        
	        String n=request.getParameter("UserId");  
	        String p=request.getParameter("Password");
	        
	        lm.setUser_Id(n);
	        lm.setPassword(p);
	        
	        login_dao ld = new login_dao();
	        String status = ld.validate(lm);
	        
	        if(status.equals("Invalidate UserName or Password")){
	   			request.setAttribute("Err","Invalidate UserName or Password");

	        	request.getRequestDispatcher("Login.jsp").forward(request,response); 
	        	
	        }
	        else{
	        	session.setAttribute("ID", n);
	        	session.setAttribute("fname", status);
	        	List<documents_model> materiallist = new ArrayList<documents_model>();
	        	documents_model rf=new documents_model();
	        	rf.setID(n);
	        	docs_dao dao1= new docs_dao();
	        	materiallist=dao1.getMaterialFileList(rf);
	        	request.setAttribute("materiallist", materiallist);
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
	        	dispatcher.forward(request, response);
	        	
	        	
	        
	        }

	    }  
	
}
