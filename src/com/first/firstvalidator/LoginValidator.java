package com.first.firstvalidator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.first.firstbeans.LoginBean;
import com.first.firstservice.LoginService;


//@Service
//@Qualifier("controllerOneValidator")
public class LoginValidator implements Validator{
	 private Pattern pattern;    
	 private Matcher matcher;    
	 
	 private LoginService loginService;
	 
	 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"    
	   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 private boolean isResult=false;
	 
	@Override
	public boolean supports(Class clazz) {
		//just validate the TextboxBean instances
		return LoginBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("LoginValidator.validate()");
		LoginBean loginBean  = (LoginBean)obj;
		loginService = new LoginService();
		
		if(loginBean.getTxtPassword()!=null && !loginBean.getTxtUsername().isEmpty()) {
			pattern = Pattern.compile(EMAIL_PATTERN);    
		   matcher = pattern.matcher(loginBean.getTxtUsername());    
		   if (!matcher.matches()) {    
		    errors.rejectValue("txtUsername", "email.incorrect",    
		      "Invalid format of email");    
		   }    
		}
		if(loginBean.getTxtPassword()!=null && !loginBean.getTxtPassword().isEmpty()) {
			if(loginBean.getTxtPassword().length()<8) {
				errors.rejectValue("txtPassword", "password.incorrect",    
					      "Password Should be more than 7 characters");
			}
		}
		if(loginBean.getTxtUsername()!=null && !loginBean.getTxtUsername().isEmpty() && loginBean.getTxtPassword()!=null && !loginBean.getTxtPassword().isEmpty()) {
			System.out.println("Username and PAssword not empty");
			isResult = loginService.authenticate(loginBean.getTxtUsername(), loginBean.getTxtPassword());
			System.out.println("isResult"+isResult);
			
			if(!isResult) {
				System.out.println("authenticate LoginValidator coming");
				errors.rejectValue("txtUserPassError", "usernamepassword.incorrect", "Username or Password is incorrect");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "txtUsername",
				"required.userName", "Username is mandatory.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "txtPassword",
				"required.password", "Password is mandatory.");
	}
	
}
