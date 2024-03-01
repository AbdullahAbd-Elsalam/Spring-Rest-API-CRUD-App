<%--
  Created by IntelliJ IDEA.
  User: Computec
  Date: 2/14/2024
  Time: 9:10 PM
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
</head>>
<body>


<div class="container">
    <%--    make form validation --%>

    <div>
        <form:form action="processAddProduct" modelAttribute="productDetails" >
            <div class="container">
                <div class="justify-content-sm-center">
                    <div class="col-md-6">
                        <div class="form-group">
                            <h3>Add Product</h3>
                        </div>


                        <div class="form-group">
                            <label for="name">product name</label>
                            <form:input type="text" cssClass="form-control" path="name" placeholder="Enter product name"/>
                            <form:errors path="name" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="expirationDate">Expiration Date</label>
                            <form:input type="text" cssClass="form-control" path="expirationDate"   placeholder="dd/mm/yyyy"/>
                            <form:errors path="expirationDate" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="manufacturer">Manufacturer</label>
                            <form:input type="text" cssClass="form-control" path="manufacturer"   placeholder="Manufacturer"/>
                            <form:errors path="manufacturer" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="price">Price</label>
                            <form:input type="text" cssClass="form-control" path="price"   placeholder="Price"/>
                            <form:errors path="price" cssClass="error"/>
                        </div>
                        <div class="form-group">
                            <label for="available">Availability</label>
                            <form:input type="text" cssClass="form-control" path="available"   placeholder="0 or 1"/>
                            <form:errors path="available" cssClass="error"/>
                        </div>
                        <input type="submit" class="btn btn-primary"/>

                    </div>
                </div>

            </div>




        </form:form>
    </div>

</div>

</body>
</html>
