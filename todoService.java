package com.web.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

//dependency injection
@Service
public class todoService {
	
	private static List<todo> todos = new ArrayList<todo>();
	private static int todoCount = 3;

	static {
		todos.add(new todo(1, "user1", "Learn", new Date(),
				false));
		todos.add(new todo(2, "user1", "play", new Date(), false));
		todos.add(new todo(3, "user1", "sleep", new Date(),
				false));
	}
	
	public todo retrieveTodo(int id) {
		for (todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	public void updateTodo(todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}
	
	public List<todo> retrieveTodos(String user) {
		List<todo> filteredTodos = new ArrayList<todo>();
		for (todo todo : todos) {
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}
	
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new todo(++todoCount, name, desc, targetDate, isDone));
	}
	
	public void deleteTodo(int id) {
		Iterator<todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}

}
