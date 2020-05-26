<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>Management</h1>
    <h2>
        <a href="product?action=product">List ALL Product</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit
                </h2>
            </caption>
            <c:if test="${product != null}">
                <input type="hidden" name="productId" value="<c:out value='${product.productId}' />"/>
            </c:if>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="productName" size="45"
                           value="<c:out value='${product.productName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="productPrice" size="45"
                           value="<c:out value='${product.productPrice}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="productPrice" size="45"
                           value="<c:out value='${product.productQuantity}' />"/>
                </td>
            </tr>
            <tr>
                <th>Colour:</th>
                <td>
                    <input type="text" name="colour" size="45"
                           value="<c:out value='${product.productColour}' />"/>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="productPrice" size="45"
                           value="<c:out value='${product.productPrice}' />"/>
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>

                    <input type="text" name="categoryName" size="45"
                           value="<c:out value='${product.categoryName}' />"/>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>