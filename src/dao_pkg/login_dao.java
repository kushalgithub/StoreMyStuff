package dao_pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import model_pkg.login_model;

public class login_dao {
    public static String validate(login_model ld) {        
      
        Connection conn = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "se_lab";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "1234";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);

            Statement st=(Statement) conn.createStatement();
    		 rs=st.executeQuery("select * from tbl_registration");
    	
    		while(rs.next()){
    			
    			String userid=rs.getString("User_Id");
    			String pass=rs.getString("Password");
    			String fname=rs.getString("FirstName");
    			
    			if(userid.equals(ld.getUser_Id()) && pass.equals(ld.getPassword())){
  
    				return fname;
    			}
    			
    		}
    	 }
    	 catch(Exception e){
    		 
    	 }
    	 return "Invalidate UserName or Password";
    	 }   

    }