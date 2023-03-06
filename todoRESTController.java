package com.web.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//create a REST controller 
@RestController
public class todoRESTController {
	@Autowired
	todoService service;
	
	@RequestMapping(path = "/todos")
	public List<todo> retrieveAllTodos(){
		return service.retrieveTodos("user1");
	}
	
}
