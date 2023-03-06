package com.web.exception;

import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Global Controller
@ControllerAdvice
public class ExceptionController {
	
	private Log logger = LogFactory.getLog(ExceptionController.class);
	
	//Global exception handler
	@ExceptionHandler(value = Exception.class)
	public String handleException(HttpServlet request, Exception ex) {
		logger.error("Request " + request.getRequestURL() + "Threw an exception", ex);
		return "error";
	}
	

}
