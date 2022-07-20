<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Style-Type" content="text/css; charset=ISO-8859-1">
<style type="text/css">
body {
 background-color:lightblue	;
}

      
.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 14px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 20px;
  margin: 8px 0px;
  border-radius: 4px;
  cursor: pointer;
  width: 20%;
}
  

h1{
  background-color: #F1F1F1;
  text-align: center;
  padding: 20px;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  text-align: center;
}
</style>

<title>Welcome to Medicare</title>
</head>
<body>
	<a href="index.jsp"  class="button">Home</a>
	<h1>Welcome to Medicare</h1>
	<div>
	<a href="PatientLogin.jsp" class="button">Sign in</a>
	<br>
	<br>
	<a href="PatientCreate.jsp" class="button">Sign up</a>
	</div>
	<br/><br/>


	

</body>
</html>>