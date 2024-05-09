<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Groceries</title>
</head>
<body>
<h2>Groceries List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${groceries}" var="grocery">
        <tr>
            <td>${grocery.id}</td>
            <td>${grocery.name}</td>
            <td>${grocery.price}</td>
            <td>${grocery.quantity}</td>
            <td><a href="editGrocery/${grocery.id}">Edit</a></td>
            <td><a href="deleteGrocery/${grocery.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="groceryForm">Add New Grocery</a>
</body>
</html>
