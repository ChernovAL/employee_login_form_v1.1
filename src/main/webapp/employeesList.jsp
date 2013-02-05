<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employees list</title>
</head>
<body style="margin: 0; padding: 0; text-align: center;">

     <h3>Employees list:</h3>

     <c:forEach var="employee" items="${employees}">
        <div>
            <h5>Name: <c:out value="${employee.name}"></c:out></h5>
            <h5>Surname: <c:out value="${employee.surname}"></c:out></h5>
            <h5>Birthday: <c:out value="${employee.birthday}"></c:out></h5>
            <h5>Email: <c:out value="${employee.email}"></c:out></h5>
            <h5>Password: <c:out value="${employee.password}"></c:out></h5>
        </div>
        <a href="/editForm?name=<c:out value="${employee.name}"></c:out>">Edit.</a>
     </c:forEach>

     <a href="loginForm.jsp">Login.</a>

</body>
</html>