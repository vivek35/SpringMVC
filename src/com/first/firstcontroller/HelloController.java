package com.first.firstcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.first.firstbeans.CustomerBean;

@Controller
@RequestMapping("/welcome")
@SessionAttributes("customerBean")
public class HelloController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String helloworld() {
		return "HelloPage";
	}
	
	@ModelAttribute("loadCustomers")
	public List<CustomerBean> getCustomers(){
		List<CustomerBean> cs = new ArrayList<CustomerBean>();
		cs.add(new CustomerBean("Vivek","Gaikwad","10-10-1990","112233"));
		cs.add(new CustomerBean("Tejas","Desai","08-03-1992","445566"));
		cs.add(new CustomerBean("Leo","Thomas","26-15-1995","778899"));
		cs.add(new CustomerBean("Bibek","Shreshta","17-08-1998","123456"));
		return cs;
	}
}
