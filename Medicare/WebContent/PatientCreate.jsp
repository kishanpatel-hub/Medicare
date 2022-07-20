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

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
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
</style>

<title>Create a Patient</title>
</head>
<body>
	
	<h1>Sign Up</h1>
	<div>
	<form action="patientcreate" method="post">
		<p>
			<label for="firstname">FirstName</label>
			<input type="text" id="firstname" name="firstname" value="">
		</p>
		<p>
			<label for="lastname">LastName</label>
			<input type="text" id="lastname" name="lastname" value="">
		</p>
		<p>
			<label for="age">Age</label>
			<input type="text" id="age" name="age" value="">
		</p>
		<p>
		<label for="gender">Gender</label>
		<br/>
		<br/>
		<INPUT TYPE="radio" id="gender" name="gender" value="male"/>Male
		<INPUT TYPE="radio" id="gender" name="gender" VALUE="female"/>Female
		</p>
		<p>
			<label for="phone">Phone</label>
			<input type="text" id="phone" name="phone" value="">
		</p>
		<p>
			<label for="street">Street</label>
			<input type="text" id="street" name="street" value="">
		</p>
		<p>
			<label for="city">City</label>
			<input type="text" id="city" name="city" value="">
		</p>
		<p>
			<label for="zip">ZIP</label>
			<input type="text" id="zip" name="zip" value="">
		</p>
		<p>
			<label for="dob">DoB (yyyy-mm-dd)</label>
			<input type="text" id="dob" name="dob" value="">
		</p>
		<p>
			<label for="bloodgroup">BloodGroup</label>
			<input type="text" id="bloodgroup" name="bloodgroup" value="">
		</p>
		<p>
			<label for="height">Height</label>
			<input type="text" id="height" name="height" value="">
		</p>
		<p>
			<label for="weight">Weight</label>
			<input type="text" id="weight" name="weight" value="">
		</p>
		<p>
			<label for="policyno">PolicyNo</label>
			<input type="text" id="policyno" name="policyno" value="">
		</p>
		<p>
			<label for="insurance">Insurance Company</label>
			<input type="text" id="insurance" name="insurance" value="">
    	</p>
    	<p>
			<label for="username">Username</label>
			<input type="text" id="username" name="username" value="">
    	</p>
    	<p>
			<label for=password>Password</label>
			<input type="text" id="password" name="password" value="">
    	</p>
		<p>
			<input type="submit" value="Submit">
		</p>
	</form>
	</div>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
	

</body>
</html>