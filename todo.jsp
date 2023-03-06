<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> <!-- form binding and make variable available in bean -->


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add</title>
	<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css"
    	rel="stylesheet">
</head>
<body>
	<%@ include file = "common/navigation.jspf" %>
	
	<div class = "container">
		<h1>Add a Todo</h1>
		<form:form method = "post" modelAttribute="todo">
			
			<form:hidden path = "id"/> <!-- value not showing on the sceen but need to return -->
			
			<fieldset class = "form-group">
				<form:label path = "desc">Description</form:label> 
				<form:input path = "desc" type = "text" class = "form-control" required = "required"/>	
				<form:errors path ="desc" cssClass = "textwarning"/> 
			</fieldset>
			
			<fieldset class = "form-group">
				<form:label path = "targetDate">Target Date</form:label> 
				<form:input path = "targetDate" type = "text" class = "form-control" required = "required"/>	
				<form:errors path ="targetDate" cssClass = "textwarning"/> 
			</fieldset>
			<BR/>
			<input class = "btn btn-success" type = "submit" value = "Submit"/>
	
		</form:form>
	</div>
<%@ include file = "common/footer.jspf" %>