<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ejbdemo</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/trigger" method="post">
		<select name="action">
			<option value="LocalStatelessEJBDemo">Local stateless EJB demo</option>
			<option value="RemoteStatelessEJBDemo">Remote stateless EJB demo</option>
		</select>
		<input type="submit" value="Submit" />
	</form>
</form>
</body>
</html>