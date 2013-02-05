<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employees list</title>
    <style>

        table {
            width: 500px;
            border: 2px solid #696969;
            margin: auto;
        }
        td {
            text-align: center;
        }

    </style>
</head>
<body style="margin: 0; padding: 0; text-align: center;">

     <h3>Employees list:</h3>

     <table>
         <thead>
         <tr>
             <th>Name</th>
             <th>Surname</th>
             <th>Birthday</th>
             <th>Email</th>
             <th>Password</th>
             <th>Edit</th>
         </tr>
         </thead>
         <tbody>
             <c:forEach var="employee" items="${employees}">
                 <tr>
                     <td><c:out value="${employee.name}"></c:out></td>
                     <td><c:out value="${employee.surname}"></c:out></td>
                     <td><c:out value="${employee.birthday}"></c:out></td>
                     <td><c:out value="${employee.email}"></c:out></td>
                     <td><c:out value="${employee.password}"></c:out></td>
                     <td><a href="/editForm?name=<c:out value="${employee.name}"></c:out>">Edit.</a></td>
                 </tr>
             </c:forEach>
         </tbody>
     </table>

     <a href="loginForm.jsp">Login.</a>
</body>
</html>