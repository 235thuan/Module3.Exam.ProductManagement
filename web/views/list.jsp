<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>

<h1>Product Management</h1>
<h2>
    <a href="/product?action=create">Add New Product</a>
</h2>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of products</h2></caption>
        <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Colour</th>
            <th>Description</th>
            <th>Category</th>
            <th>Others</th>
        </tr>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td><c:out value="${product.productId}"/></td>
                <td><c:out value="${product.productName}"/></td>
                <td><c:out value="${product.productPrice}"/></td>
                <td><c:out value="${product.productQuantity}"/></td>
                <td><c:out value="${product.productColour}"/></td>
                <td><c:out value="${product.productDescription}"/></td>
                <td><c:out value="${product.categoryName}"/></td>
                <td>
                    <a href="/product?action=edit&id=${product.productId}">Edit</a>
                    <a href="/product?action=delete&id=${product.productId}">Delete</a>
                </td>
            </tr>
        </c:forEach>


    </table>
    <div>


        <c:if test="${currentPage !=1}">
            <li style="display: inline">
                <a href="product?page=${currentPage -1}">
                </a>

            </li>
        </c:if>
        <c:forEach begin="1" end="${noOfPages}" var="i">
            <li style="display: inline">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <a>${i}
                        </a>
                    </c:when>
                    <c:otherwise>
                        <a href="product?page=${i}">${i}
                        </a>
                    </c:otherwise>
                </c:choose>

            </li>
        </c:forEach>
        <c:if test="${currentPage} <= ${noOfpages}">
            <li style="display: inline">
                <a href="product?page=${currentPage +1}">
                </a>
            </li>
        </c:if>

    </div>
</div>
</body>
</html>