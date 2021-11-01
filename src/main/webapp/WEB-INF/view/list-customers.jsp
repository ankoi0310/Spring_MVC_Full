<%--
  Created by IntelliJ IDEA.
  User: Huỳnh Văn Hữu Ân
  Date: 10/30/2021
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Customer</title>
</head>
<body>
    <h2>Customer Relationship Manager</h2>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
        </tr>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
