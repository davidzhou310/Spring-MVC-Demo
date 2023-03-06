<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
	<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css"
    	rel="stylesheet">
</head>
<body>

	<%@ include file = "common/navigation.jspf" %>
	
	Welcome ${name} <BR/>
	Now you can <a href = "list-todos">manage your todos.</a>

<%@ include file = "common/footer.jspf" %>