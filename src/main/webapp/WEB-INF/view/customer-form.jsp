<%--
  Created by IntelliJ IDEA.
  User: Huỳnh Văn Hữu Ân
  Date: 11/3/2021
  Time: 8:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Save Customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
    <div class="d-flex justify-content-center py-5">
        <h2>Customer Form</h2>
    </div>
    <div class="container">
        <form:form action="saveCustomer" modelAttribute="customer" method="post">
            <form:hidden path="id" />
            <div class="form-group row">
                <label for="firstName" class="col-2 col-form-label">First Name</label>
                <div class="col-4">
                    <form:input path="firstName" class="form-control" id="firstName" placeholder="First Name"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="lastName" class="col-2 col-form-label">Last Name</label>
                <div class="col-4">
                    <form:input path="lastName" class="form-control" id="lastName" placeholder="Last Name"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="email" class="col-2 col-form-label">Email</label>
                <div class="col-4">
                    <form:input path="email" class="form-control" id="email" placeholder="Email"/>
                </div>
            </div>
            <div class="form-group row">
                <div class="offset-2 col-4">
                    <input type="submit" class="btn btn-primary" value="Submit"/>
                </div>
            </div>
        </form:form>
    </div>
</body>
</html>
