<!-- homePage.jsp -->


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
<body>
<h2>Product List</h2>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="searchProduct" method="get">
                <div class="input-group mb-3">
                    <input type="text" name="name" class="form-control" placeholder="enter product name " aria-label="Search" aria-describedby="button-addon2">
                    <button class="btn btn-primary" type="submit" id="button-addon2">Search</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="container">


<%--    show list of product as atable--%>

    <table class="table">
        <!-- Table headers -->
        <div class="table-group-divider">

            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">show Details</th>
                <th scope="col">update</th>
                <th scope="col">delete</th>


            </tr>
            </thead>
        </div>

        <!-- Table body -->
        <div>

            <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <!-- construct an "view details" link with product id -->
                    <td>
                        <c:url var="showProducts" value="/showDetails">

                            <c:param name="id" value="${product.id}"></c:param>
                        </c:url>
                        <a class="btn btn-danger" href="${showProducts}">view Details</a>
                    </td>

                    <!-- construct an "update details" link with product id -->
                   <td>
                         <c:url var="updateProduct" value="/updateDetails">

                            <c:param name="id" value="${product.id}"></c:param>
                        </c:url>
                        <a class="btn btn-secondary" href="${updateProduct}">Update  </a>
                    </td>
                    <!-- construct an " delete product " link with product id -->

                    <td>

                        <c:url var="deleteProduct" value="/deleteProduct">

                            <c:param name="id" value="${product.id}"></c:param>
                        </c:url>
                        <a class="btn btn-warning" href="${deleteProduct}"> Delete  </a>
                    </td>


                </tr>
            </c:forEach>
            </tbody>
        </div>



    </table>
    <div class="container-fluid">

        <form:form action="addProduct" method="get">
            <input type="submit" class="btn btn-success" value="Add new Product"/>
        </form:form>
    </div>


  </div>
</body>
</html>
