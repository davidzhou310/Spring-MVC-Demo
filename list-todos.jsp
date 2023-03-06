<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Todos for ${name}</title>
	<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css"
    	rel="stylesheet">
</head>
<body>

	<%@ include file = "common/navigation.jspf" %>
	
	<div class = "container">
		<caption><spring:message code = "todo.caption" /></caption>
		<table class = "table table-striped">
			<thead>
				<tr>
					<th>Description</th>	
					<th>Target Date</th>
					<th>Is Completed?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items = "${todos}" var = "todo">
					<tr>
						<td>${todo.desc}</td> 
						<td><fmt:formatDate pattern="dd/MM/yyyy" value = "${todo.targetDate}" /></td>
						<td>${todo.isdone}</td>	
						<td><a href = "/update-todo?id=${todo.id}" class = "btn btn-success">update</a></td>
						<td><a href = "/delete-todo?id=${todo.id}" class = "btn btn-danger">delete</a></td>
					</tr>
				</c:forEach> 
			</tbody>
		</table>
		<div>
			<a class= "btn btn-success" href = "/add-todo">Add</a>
		</div>
	</div>
<%@ include file = "common/footer.jspf" %>