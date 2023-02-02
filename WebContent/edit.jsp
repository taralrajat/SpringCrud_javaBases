<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>

<form action="update">

<pre>

           <input type="hidden" name="id" value="${emp.id}">

Name     : <input type="text" name="name" value="${emp.name}">

Username : <input type="text" name="username" value="${emp.username}">

Password : <input type="text" name="password" value="${emp.password}">

City     : <input type="text" name="addr.city" value="${emp.addr.city}">

 <input type="submit" value="Update">

</pre>

</form>

</body>
</html>