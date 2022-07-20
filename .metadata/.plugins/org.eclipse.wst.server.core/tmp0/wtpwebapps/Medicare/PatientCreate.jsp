<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a Patient</title>
</head>
<body>
	<h1>Create Patient</h1>
	<form action="patientcreate" method="post">
		<p>
			<label for="firstname">FirstName</label>
			<input id="firstname" name="firstname" value="">
		</p>
		<p>
			<label for="lastname">LastName</label>
			<input id="lastname" name="lastname" value="">
		</p>
		<p>
			<label for="age">Age</label>
			<input id="age" name="age" value="">
		</p>
		<p>
		<INPUT TYPE="radio" name="gender" value="male"/>male
		<INPUT TYPE="radio" name="gender" VALUE="female"/>female
		</p>
		<p>
			<label for="phone">Phone</label>
			<input id="phone" name="phone" value="">
		</p>
		<p>
			<label for="street">Street</label>
			<input id="street" name="street" value="">
		</p>
		<p>
			<label for="city">City</label>
			<input id="city" name="city" value="">
		</p>
		<p>
			<label for="zip">ZIP</label>
			<input id="zip" name="zip" value="">
		</p>
		<p>
			<label for="dob">DoB (yyyy-mm-dd)</label>
			<input id="dob" name="dob" value="">
		</p>
		<p>
			<label for="bloodgroup">BloodGroup</label>
			<input id="bloodgroup" name="bloodgroup" value="">
		</p>
		<p>
			<label for="height">Height</label>
			<input id="height" name="height" value="">
		</p>
		<p>
			<label for="weight">Weight</label>
			<input id="weight" name="weight" value="">
		</p>
		<p>
			<label for="policyno">PolicyNo</label>
			<input id="policyno" name="policyno" value="">
		</p>
		
		Select a Insurance Company:&nbsp;
    	<select name="insurance">
        	<c:forEach items="${listInsurance}" var="insurance">
            	<option value="${insurance.insCom_ID}">${insurance.insCom_Name}</option>
        	</c:forEach>
    	</select>
		<p>
			<input type="submit">
		</p>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
</body>
</html>