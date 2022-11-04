<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<style>
#medicines {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#medicines td, #medicines th {
  border: 1px solid #ddd;
  padding: 8px;
}

#medicines tr:nth-child(even){background-color: #f2f2f2;}

#medicines tr:hover {background-color: #ddd;}

#medicines th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>

<body>

<h2 align="center">All Medicines</h2>

<table id="medicines">
<tr>
<th>Medicine ID</th>
<th>Medicine Name</th>
<th>Medicine Price</th>
<th>Medicine Stock</th>
</tr>
<c:forEach var="pharmacy" items="${pharmacy}">
<tr>

<td>${pharmacy.medicineId}</td>
<td>${pharmacy.medicineName}</td>
<td>${pharmacy.medicinePrice}</td>
<td>${pharmacy.medicineStock}</td>

</tr>
</c:forEach>
</table>
</body>
</html>