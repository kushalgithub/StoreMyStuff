package controller_pkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao_pkg.reg_dao;
import model_pkg.Reg_model;
import validation.Validation;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String fname = request.getParameter("FirstName");
   		String lname = request.getParameter("LastName");
   		String email = request.getParameter("Email");
   		String userid = request.getParameter("UserId");
   		String pass = request.getParameter("Password");
   		
   		Reg_model reg = new Reg_model();
   		reg_dao dao = new reg_dao();
   		
   		reg.setFirstName(fname);
   		reg.setLastName(lname);  
   		reg.setEmail(email);
   		reg.setUser_Id(userid);
   		reg.setPassword(pass);
   		
   		
   		Validation valid = new Validation();
   		
   		String validate_value = valid.validate(reg);
   		
   		if(validate_value.equals("please fill all the fields")){
   			request.setAttribute("err",validate_value);
   			request.getRequestDispatcher("/Registration.jsp").forward(request,response); 
   			
   			
   		}
   		
   		else if(validate_value.equals("Firstname should be characters")){
   			request.setAttribute("err",validate_value);
   			request.getRequestDispatcher("/Registration.jsp").forward(request,response); 
   			
   		}
   		
   		else if(validate_value.equals("Laststname should be characters")){
   			request.setAttribute("err",validate_value);
   			request.getRequestDispatcher("/Registration.jsp").forward(request,response); 
   			
   		}
   		
   		else if(validate_value.equals("Email should be characters")){
   			request.setAttribute("err",validate_value);
   			request.getRequestDispatcher("/Registration.jsp").forward(request,response); 
   			
   		}
   		
   		else if(validate_value.equals("Userid should be integer")){
   			request.setAttribute("err",validate_value);
   			request.getRequestDispatcher("/Registration.jsp").forward(request,response); 
   		
   		}
   		
   		else if(validate_value.equals("Password should be characters")){
   			request.setAttribute("err",validate_value);
   			request.getRequestDispatcher("/Registration.jsp").forward(request,response); 
   			
   		}
   		   	
   		else{
   			request.setAttribute("success","Successfully registered");
   			request.getRequestDispatcher("/Login.jsp").forward(request,response); 
   			dao.add(reg);
   		}
	}

}
