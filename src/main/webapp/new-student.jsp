<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 10/31/2023
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student</title>
</head>
<body>
<h1>Create Student</h1>

<%--<c:if test="${not empty user}">--%>
<form action="insert" method="post">
    <label>Id</label>
    <input type="text" name="id" value="${student.id}">
    <br>

    <label>First name</label>
    <input type="text" name="FirstName" value="${student.firstName}">
    <br>

    <label>Last name</label>
    <input type="text" name="LastName" value="${student.lastName}">
    <br>

    <label>email</label>
    <input type="text" name="email" value="${student.email}">
    <br>

    <input type="submit" value="Save">


</form>
</body>
</html>
