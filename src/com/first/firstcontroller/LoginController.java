package com.first.firstcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.first.firstbeans.LoginBean;
import com.first.firstservice.LoginService;
import com.first.firstvalidator.LoginValidator;

@Controller
@RequestMapping("/login")
@SessionAttributes("loginBean")
public class LoginController {
	
	private LoginValidator loginValidator;
	
	@Autowired(required=false)
	public LoginController(LoginValidator loginValidator) {
		this.loginValidator = loginValidator;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String doPost(@ModelAttribute("loginBean") LoginBean loginBean, BindingResult bindingResult, SessionStatus status) throws Exception{
		
		
		loginValidator.validate(loginBean, bindingResult);
		LoginService loginService = new LoginService();
		
		if(bindingResult.hasErrors()) {
			System.out.println("Errors present in binding error");
			List<FieldError> errors = bindingResult.getFieldErrors();
			for(FieldError fieldError: errors) {
				System.out.println("Error: "+fieldError.getDefaultMessage());
			}
			return "jspLoginFormView";
		}else {
			System.out.println("No errors found");
			status.setComplete();
			boolean isResult = loginService.authenticate(loginBean.getTxtUsername(), loginBean.getTxtPassword());
			if(isResult) {
				System.out.println("Valid User");
				return "redirect:welcome";
			}
			return "jspLoginFormView";
		}
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String doGet(ModelMap model) {
		LoginBean loginBean = new LoginBean();
		model.addAttribute("loginBean", loginBean);
		return "jspLoginFormView";
	}
	
	@ModelAttribute("loginBean")
	public LoginBean setUpLoginForm() {
		return new LoginBean();
	}
}
