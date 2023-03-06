package com.web.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Logout(HttpServletRequest request, HttpServletResponse response) {
		//terminate authentication
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth  != null) {
			new SecurityContextHolder().logout(request, response, auth);
		}
		//redirect to home page
		return "redirect:/";
	}	

}
