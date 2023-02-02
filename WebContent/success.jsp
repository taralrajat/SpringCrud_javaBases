<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
<script type="text/javascript">

function del() {
	document.myform.action="delete";
	document.myform.submit();
}

function edit() {
	document.myform.action="edit";
	document.myform.submit();
}

</script>

</head>
<body>
<h1>Success...!!!!</h1>
<form name="myform">
	<table border="2">
		<tr>
			<th>Name</th>
			<th>Username</th>
			<th>Password</th>
		</tr>
		
		   <c:forEach items="${Data}" var="e">
			<tr>
				<td><c:out value="${e.name}"></c:out></td>
				<td><c:out value="${e.username}"></c:out></td>
				<td><c:out value="${e.password}"></c:out></td>	
				<td><c:out value="${e.addr.city}"></c:out></td>
				<td><input type="radio" name="id" value="${e.id}"></td>
			</tr>
			</c:forEach>
			
			<tr>
				<td><input type="button" value="Delete" onclick="del()"></td>
				<td><input type="button" value="Edit" onclick="edit()"></td>
			</tr>
		
	</table>
</form>
</body>
</html>