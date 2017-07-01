package controller_pkg;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao_pkg.docs_dao;
import model_pkg.docs_model;
import model_pkg.documents_model;

/**
 * Servlet implementation class uploadservlet
 */
@WebServlet("/uploadservlet")
@MultipartConfig(maxFileSize = 428496729)
public class uploadservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadservlet() {
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
		
		
		
		
		HttpSession session = request.getSession();
		 String comment = request.getParameter("comments");
		 System.out.println("in servlet");
		String userId=(String)session.getAttribute("ID");
		System.out.println("User ID :" +userId);
		Part filePart = request.getPart("fileupload");
		String file_type=null;
		InputStream inputStream = null;
		String file_name=null;
		
		if (filePart != null) {
           inputStream = filePart.getInputStream();
   		 file_name=getFileName(filePart);
   		 file_type=filePart.getContentType();
		}
	
		docs_model dm= new docs_model();
		documents_model docm =new documents_model();
		dm.setFile(inputStream);
		dm.setFileName(file_name);
		dm.setFileType(file_type);
		dm.setComments(comment);	
		dm.setID(userId);
		
		
		

		docs_dao dao= new docs_dao();
		dao.Insert(dm);
		docm.setID(userId);
		
		List<documents_model> materiallist = new ArrayList<documents_model>();
		materiallist=dao.getMaterialFileList(docm);
		
		request.setAttribute("materiallist", materiallist);
		
		
		
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
		dispatcher.forward(request, response);
	   
			    
		
	}

	private String getFileName(Part f) {
		// TODO Auto-generated method stub
		final String partHeader = f.getHeader("content-disposition");
	    //LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
	    for (String content : f.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
		
	}

}
