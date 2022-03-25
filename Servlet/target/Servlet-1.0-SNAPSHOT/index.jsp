<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <h1 style="text-align: center">Car servlet app</h1>
</head>
<body>
<h2>
    <a style="text-align: justify" href="all">All Items</a>
    <a style="text-align: justify" href="match">Matched Items</a>
</h2>
<br>
<form method="post" action="add" style="text-align: center">
    <label for="number">Number</label>
    <input type="text" id="number" name="number">
    <br>
    <label for="mark">Mark</label>
    <input type="text" id="mark" name="mark">
    <br>
    <label for="model">Model</label>
    <input type="text" id="model" name="model">
    <br>
    <label for="year">Year</label>
    <input type="number" id="year" name="year">
    <br>
    <label for="owner">Owner</label>
    <input type="text" id="owner" name="owner">
    <br>
    <label for="address">Address</label>
    <input type="text" id="address" name="address">
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>