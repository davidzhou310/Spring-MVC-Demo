package com.web.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	todoService service;
	
	//store in certain format
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String listTodos(ModelMap model) {
		model.addAttribute("todo", service.retrieveTodos(retrieveLogginedUserName()));
		return "list-todos";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		model.addAttribute("todo", new todo(0, retrieveLogginedUserName(), "Default Desc", new Date(), false));
		return "todo";
	}
	
	
	//handle get update request
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String updateTodo(ModelMap model, @RequestParam int id) {
		todo todo = service.retrieveTodo(id);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	//handle post update request
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid todo todo, BindingResult result) {
		//if validation error
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUser(retrieveLogginedUserName());
		service.updateTodo(todo);
		return "redirect: list-todos";
	}
	
	//get user name
	private String retrieveLogginedUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	//handle the post request for adding 
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid todo todo, BindingResult result) {
		//if validation error
		if(result.hasErrors()) {
			return "todo";
		}
		service.addTodo(retrieveLogginedUserName(), todo.getDesc() , new Date(), false);
		//do not send anything to the URL
		model.clear();
		//after adding back to list-todo page
		//not make todos a session attribute because it is too large 
		//redirect it to the URL 
		return "redirect: list-todos";
	}
	
	//handle the post request for deleting 
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		service.deleteTodo(id);
		//do not show  anything to the URL
		model.clear();
		//after deleting back to list-todo page
		//redirect it to the URL 
		return "redirect: list-todos";
	}
	
	
}
