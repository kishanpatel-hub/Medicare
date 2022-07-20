<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Specialization</title>

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
 background-color:lightblue	;
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

table {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

table td, table th {
  border: 1px solid #ddd;
  padding: 8px;
}

table tr:nth-child(even){background-color: #f2f2f2;}

table tr:hover {background-color: #ddd;}

table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</
</style>
</head>
<body>
<a href="Adminmenu.jsp"  class="button">Back to Menu</a>
<h1>Search doctor</h1>
 
	<div id="loader">
	
    <form action="finddoctorBasedonReview" method="post">
        
        <p>
            <label for="specialization">Specialization</label>
            <input type="text" id="specialization" name="specialization" value="${fn:escapeXml(param.specialization)}">
        </p>
        <p>
        	<label for="city">City</label>
        	<input type="text" id="city" name="city" value="${fn:escapeXml(param.city)}">
        </p>
        <p>
        	<label for="review">Rating</label>
        	<input type="text" id="review" name="review" value="${fn:escapeXml(param.review)}">
        </p>
        <p>
            <input type="submit" value="Submit">
            <br/><br/><br/>
            <span id="successMessage"><b>${messages.success}</b></span>
        </p>
    </form>
 
    </div>
    <br/>

    <br/>
    <div id="result">
    <h1>Matching doctors</h1>
        <table border="5">
            <tr>

                <th>Name</th>
                <th>Age</th>
                <th>Phone</th>
                <th>Email</th>
                <th>City</th>
                <th>Gender</th>
                <th>Specialization</th>
                <th>Description</th>
                <th>Experience</th>
                <th>Rating</th>
                <th>Delete Account</th>
                
            </tr>
            <c:forEach items="${reviewList}" var="Reviews" >
                <tr>
                    <td><c:out value="${Reviews.getDoctor_ID().getName()}" /></td>
                    <td><c:out value="${Reviews.getDoctor_ID().getAge()}" /></td>
                    <td><c:out value="${Reviews.getDoctor_ID().getPhone()}" /></td>
                    <td><c:out value="${Reviews.getDoctor_ID().getEmail()}" /></td>
                    <td><c:out value="${Reviews.getDoctor_ID().getCity()}" /></td>
                    <td><c:out value="${Reviews.getDoctor_ID().getGender()}" /></td>
                    <td><c:out value="${Reviews.getDoctor_ID().getSpecialization()}" /></td>
                    <td><c:out value="${Reviews.getDoctor_ID().getDescription()}" /></td>
                    <td><c:out value="${Reviews.getDoctor_ID().getExperiance()}" /></td>
                    <td><c:out value="${Reviews.getRating()}" /></td>
                    <td><a href="DeleteDoctor?doctorID=<c:out value="${Reviews.getDoctor_ID().getDoctor_ID()}"/>">Delete</a></td>
                </tr>
            </c:forEach>
       </table>
       </div>
       
      
</body>
</html>