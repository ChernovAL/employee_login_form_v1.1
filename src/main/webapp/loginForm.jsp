<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <style>
        .errors{
            color: red;
            display: inline;
        }
    </style>
</head>
    <body style="margin: 0; padding: 0; text-align: center;">
        <h3>Login</h3>

        <c:forEach var="error" items="${errorsList}">
            <h5 class="errors"><c:out value="${error}"></c:out></h5>
        </c:forEach>

        <form method="post" action="/employeeServlet">
            Name:</br>
            <input type="text" placeholder="Inser name" name="name" value="<c:out value="${employee.name}"></c:out>" ></br>
            Surname:</br>
            <input type="text" placeholder="Inser surname" name="surname" value="<c:out value="${employee.surname}"></c:out>"></br>
            Birthday:</br>
            <input type="date" placeholder="Insert birthday" name="birthday" value="<c:out value="${employee.birthday}"></c:out>"></br>
            Email:</br>
            <input type="email" placeholder="Insert email" name="email" value="<c:out value="${employee.email}"></c:out>"></br>
            Password:</br>
            <input type="password" placeholder="Insert password" name="password"></br>
            Confirm password</br>
            <input type="password" placeholder="Confirm password" name="pass_confirm"></br>
            Save in:
            <input type="radio" name="save_in" value="xml" checked="checked"> XMl file
            <input type="radio" name="save_in" value="database"> Database </br>
            <input type="submit" value="Submit"/>
            <input type="reset" value="Reset"/>
        </form>
        <a href="/employeeList">Employees list.</a>
    </body>
</html>