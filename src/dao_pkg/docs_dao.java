package dao_pkg;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

import model_pkg.docs_model;
import model_pkg.documents_model;

public class docs_dao {

	public void Insert(docs_model dm)
	{
		InputStream inputStream = null;
		 try{
	    	 Connection  con= null;
	    
	        

	    Class.forName("com.mysql.jdbc.Driver");
	    

	//creating connection with the database 
	        con=DriverManager.getConnection
	                 ("jdbc:mysql://localhost:3306/se_lab","root","1234");
	        
	        String sql="INSERT INTO tbl_docs(ID,FileName, FileType,Comments,File) values(?,?,?,?,?)";
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, dm.getID());
			pst.setBlob(5, dm.getFile());
			pst.setString(2, dm.getFileName());
			pst.setString(3, dm.getFileType());
			pst.setString(4, dm.getComments());
			int temp_data=pst.executeUpdate();
			if(temp_data>0){
				
				pst.close();
			con.close();
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
	}
	
	public List<documents_model> getMaterialFileList(documents_model dm) {
		// Course course = new Course();
		List<documents_model> materiallist = new ArrayList<documents_model>();
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/se_lab","root","1234");
		Statement stmt1 = (Statement) con.createStatement();
		ResultSet rs = stmt1.executeQuery("select * from tbl_docs where ID='"+dm.getID()+"'");
		
		while (rs.next()) {
			
			documents_model dmob = new documents_model();
			dmob.setDocId(rs.getInt("DocId"));
			dmob.setFile(rs.getBlob("File"));
			dmob.setFileName(rs.getString("FileName"));
			dmob.setFileType(rs.getString("FileType"));
			dmob.setComments(rs.getString("Comments"));
			dmob.setID("ID");
			materiallist.add(dmob);

		}
		stmt1.close();
		con.close();
		
		
		}
		catch(Exception e){
			System.out.println(e);
		}
		return materiallist;

	}
	public static documents_model getMaterial(int materialid) throws ClassNotFoundException, SQLException {
		documents_model dm = new documents_model();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/se_lab","root","1234");
		Statement st=(Statement) con.createStatement();
		System.out.println(materialid);
		ResultSet rs = st.executeQuery("select * from tbl_docs where DocId ='"+materialid+"'");
		
		rs.next();
		dm.setDocId(rs.getInt("DocId"));
		dm.setFile(rs.getBlob("File"));
		dm.setFileName(rs.getString("FileName"));
		dm.setFileType(rs.getString("FileType"));
		dm.setComments(rs.getString("Comments"));
		dm.setID(rs.getString("ID"));
		st.close();
		con.close();
		return dm;

	}

}
