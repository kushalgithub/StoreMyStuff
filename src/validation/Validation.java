package validation;

import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

import model_pkg.Reg_model;

public class Validation {
	
	public String validate(Reg_model reg){
		
			    
		
		if(reg.getFirstName().isEmpty()||reg.getLastName().isEmpty()||reg.getEmail().isEmpty()||reg.getPassword().isEmpty()||reg.getUser_Id().isEmpty()){
		
			return "please fill all the fields";
		}
		
		else if(!reg.getFirstName().matches("^[a-zA-Z]+$")){
			return "Firstname should be characters";
			
		}
		
		else if(!reg.getLastName().matches("^[a-zA-Z]+$")){
			return "Lastname should be characters";
			
		}
		
		else if(!reg.getEmail().matches("^(.+)@(.+)$")){
			return "Email should be characters";
			
		}
		
		else if(!reg.getUser_Id().matches("^[0-9]+$")){
			return "Userid should be integer";
			
		}
		
		else if(!reg.getPassword().matches("^[a-zA-Z]+$")){
			return "Password should be characters";
			
		}
		
		else{
			return "Successfully registered";
		}
	}

}
