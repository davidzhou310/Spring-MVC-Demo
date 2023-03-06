package com.web.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//add annotation
//controller handle web request
@Controller
public class WelcomeController {
	//mapping URL to get request handler
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//no requestbody, need to solve in a view resolver 
	public String showLoginPage(ModelMap model) {
		model.put("name", "user");		
		return "welcome";
	}	

}
