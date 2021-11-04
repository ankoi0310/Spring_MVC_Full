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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
    <div class="d-flex justify-content-center py-5">
        <h2>Customer Relationship Manager</h2>
    </div>
    <div class="container">
        <div class="row pb-3">
            <input type="button" class="btn btn-primary" value="Add customer" onclick="window.location.href='showFormForAdd'; return false;">
        </div>
        <div class="row">
            <table class="table">
                <thead class="thead-dark">
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email</th>
                <th scope="col">Action</th>
                </thead>
                <tbody>
                <c:forEach items="${customers}" var="customer">
                    <%--  Example link: https://.../customer/showFormForUpdate?customerId=1 --%>
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${customer.id}" />
                    </c:url>

                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${customer.id}" />
                    </c:url>
                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                        <td>
                            <a href="${updateLink}">Update</a> |
                            <a href="${deleteLink}" onclick="if (!confirm('Are you sure you want to delete this?')) return false;">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
