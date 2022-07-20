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
</head>
<body>
    <form action="finddoctor" method="post">
        <h1>Search for a Specialization of Doctor</h1>
        <p>
            <label for="specialization">specialization</label>
            <input id="specialization" name="specialization" value="${fn:escapeXml(param.specialization)}">
        </p>
        <p>
            <input type="submit">
            <br/><br/><br/>
            <span id="successMessage"><b>${messages.success}</b></span>
        </p>
    </form>
    <br/>
    <div id="userCreate"><a href="usercreate">Create doctor</a></div>
    <br/>
    <h1>Matching doctors</h1>
        <table border="1">
            <tr>
                
                <th>FirstName</th>
                <th>LastName</th>
                <th>Age</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Specialization</th>
                <th>Description</th>
                <th>Experience</th>
            </tr>
            <c:forEach items="${doctorList}" var="Doctor" >
                <tr>
                    <td><c:out value="${Doctor.getFirst_name()}" /></td>
                    <td><c:out value="${Doctor.getLast_name()}" /></td>
                    <td><c:out value="${Doctor.getAge()}" /></td>
                    <td><c:out value="${Doctor.getPhone()}" /></td>
                    <td><c:out value="${Doctor.getEmail()}" /></td>
                    <td><c:out value="${Doctor.getGender()}" /></td>
                    <td><c:out value="${Doctor.getSpecialization()}" /></td>
                    <td><c:out value="${Doctor.getDescription()}" /></td>
                    <td><c:out value="${Doctor.getExperiance()}" /></td>
                </tr>
            </c:forEach>
       </table>
</body>
</html>