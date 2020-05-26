<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<h1> Management</h1>
<h2>
    <a href="product?action=product">List All Product</a>
</h2>

<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add Product</h2>
            </caption>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="productName" id="ProductName" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Product Price:</th>
                <td>
                    <input type="text" name="productPrice" id="productPrice" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="productQuantity" id="productQuantity" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Colour:</th>
                <td>
                    <input type="text" name="productColour" id="productColour" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="productDescription" id="productDescription" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                   <select>
                       <option value="phone">Phone</option>
                       <option value="television">Television</option>
                   </select>
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