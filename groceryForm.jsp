<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Grocery</title>
</head>
<body>
<h2>Add Grocery</h2>
<form action="saveGrocery" method="post">
    Name: <input type="text" name="name"><br>
    Price: <input type="text" name="price"><br>
    Quantity: <input type="text" name="quantity"><br>
    <input type="submit" value="Add Grocery">
</form>
</body>
</html>
