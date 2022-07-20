<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointments</title>

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

    <br/>
	<a href="ViewPatient.jsp"  class="button">Back</a>
    <br/>
   <div id="result">
    <h1>Matching Patients</h1>
        <table border="5">
            <tr>
                

                <th>Name</th>
                <th>Age</th>
                <th>Phone</th>
                <th>Address</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>Policy NO</th>
                <th>Delete</th>
                
            </tr>
            <c:forEach items="${patientList}" var="Patient" >
                <tr>
                    <td><c:out value="${Patient.getName()}" /></td>
                    <td><c:out value="${Patient.getAge()}" /></td>
                    <td><c:out value="${Patient.getPhone()}" /></td>
                    <td><c:out value="${Patient.getAddress()}" /></td>
                    <td><c:out value="${Patient.getDob()}" /></td>
                    <td><c:out value="${Patient.getGender()}" /></td>
                    <td><c:out value="${Patient.getPolicy_no()}" /></td>
                    <td><a href="DeletePatient?patientID=<c:out value="${Patient.getPatient_ID()}"/>">Delete</a></td>
                </tr>
            </c:forEach>
       </table>
       </div>
  
</body>
</html>