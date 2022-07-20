<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 7px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 20px;
  margin: 8px 0px;
  border-radius: 4px;
  cursor: pointer;
}

body {
 background-color:lightblue;
}

input[type=text], select {
  width: 20%;
  padding: 12px 20px;
  margin: 8px 0;
  display: 	block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 20%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
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
}


</
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book an Appointment</title>
</head>
<body>
<a href="DoctorMenu.jsp"  class="button">Back to Menu</a>
	<h1>Book an Appointment</h1>
	<div>
	<form action="DoctorReferral" method="post">

		<p>
			<label for="referto">DoctorID: </label>
			<input type="text" id="referto" name="referto" value="${fn:escapeXml(param.referto)}">
		</p>
		<p>
			<label for="Notes">Notes: </label>
			<input type="text" id="Notes" name="Notes" value="">
		</p>
		<p>
			<input type="submit"  value="Submit">
		</p>
		
	</form>
	</div>
	
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>

</body>
</html>