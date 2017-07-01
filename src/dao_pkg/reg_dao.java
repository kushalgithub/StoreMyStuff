package dao_pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Statement;

import model_pkg.Reg_model;

public class reg_dao {
	
	public void add(Reg_model reg){
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost/se_lab","root","1234");
			java.sql.Statement st= con.createStatement();
			st.executeUpdate("insert into tbl_registration(FirstName,LastName,Email,User_Id,Password) values('"+reg.getFirstName()+"','"+reg.getLastName()+"','"+reg.getEmail()+"','"+reg.getUser_Id()+"','"+reg.getPassword()+"')");
			st.close();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
