<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Grocery</title>
</head>
<body>
<h2>Edit Grocery</h2>
<form action="editSave" method="post">
    <input type="hidden" name="id" value="${grocery.id}">
    Name: <input type="text" name="name" value="${grocery.name}"><br>
    Price: <input type="text" name="price" value="${grocery.price}"><br>
    Quantity: <input type="text" name="quantity" value="${grocery.quantity}"><br>
    <input type="submit" value="Save Changes">
</form>
</body>
</html>
