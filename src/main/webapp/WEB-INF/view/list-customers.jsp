<%@ page import="com.koi.springmvc.constant.SortCustomerColumn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
    <c:import url="navbar.jsp"/>
    <div class="d-flex justify-content-center pb-2">
        <h2>Welcome to CRM System - <security:authentication property="principal.username"/></h2>
    </div>
    <div class="d-flex justify-content-center pb-3">
        <h5>You have roles: <security:authentication property="principal.authorities"/></h5>
    </div>
    <div class="container">
        <div class="d-flex justify-content-between align-items-center">
            <input type="button" class="btn btn-primary form-group row" value="Add customer"
               onclick="window.location.href='showFormForAdd'; return false;">
            <form:form action="search" method="get">
                <div class="form-group row">
                    <div class="col-6">
                        <input name="keyword" class="form-control mr-2" id="keyword" type="search" placeholder="Search" aria-label="Search">
                    </div>
                    <div class="col-6">
                        <input type="submit" class="btn btn-success" value="Search">
                    </div>
                </div>
            </form:form>
        </div>
        <div class="row">
            <table class="table table-bordered">
                <thead class="thead-dark text-center">
                    <%-- Links for sorting --%>
                    <c:url value="/customer/list" var="firstNameSort">
                        <c:param name="sort" value="<%=String.valueOf(SortCustomerColumn.FIRST_NAME)%>"/>
                    </c:url>
                    <c:url value="/customer/list" var="lastNameSort">
                        <c:param name="sort" value="<%=String.valueOf(SortCustomerColumn.LAST_NAME)%>"/>
                    </c:url>
                    <c:url value="/customer/list" var="emailSort">
                        <c:param name="sort" value="<%=String.valueOf(SortCustomerColumn.EMAIL)%>"/>
                    </c:url>
                    <th scope="col"><a href="${firstNameSort}">First Name</a></th>
                    <th scope="col"><a href="${lastNameSort}">Last Name</a></th>
                    <th scope="col"><a href="${emailSort}">Email</a></th>
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
