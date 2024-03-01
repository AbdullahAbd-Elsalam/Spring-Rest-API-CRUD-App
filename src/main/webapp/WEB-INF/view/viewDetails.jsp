<%--
  Created by IntelliJ IDEA.
  User: Computec
  Date: 2/14/2024
  Time: 8:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Include Bootstrap and CSS stylesheets -->
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
</head>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view details</title>
</head>
<body>

<h2>All Product Details</h2>
<div class="container">

    <table class="table">
        <!-- Table headers -->
        <div class="table-group-divider">

            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Expiration Date</th>
                <th scope="col">price</th>
                <th scope="col">manufacturer</th>
                <th scope="col">available</th>
            </tr>
            <thead>

            <tbody>
              <tr>
                 <td>${productDetails.id}</td>
                  <td>${productDetails.name}</td>
                  <td>${productDetails.expirationDate}</td>
                  <td>${productDetails.price}</td>
                  <td>${productDetails.manufacturer}</td>
                  <td>${productDetails.available}</td>

              </tr>
            </tbody>
        </div>
</body>
</html>
