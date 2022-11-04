<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
#patients {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#patients td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#patients tr:nth-child(even){background-color: #f2f2f2;}

#patients tr:hover {background-color: #ddd;}

#patients th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>

<h2 align="center">Your Appointment Details</h2>

<table id="patients">
<tr>
<th>Patient ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>Age</th>
</tr>
<c:forEach var="patient" items="${patient}">
<tr>
<td>${patient.patient_id}</td>
<td>${patient.first_name}</td>
<td>${patient.last_name}</td>
<td>${patient.age}</td>

</tr>
</c:forEach>

</table>
</body>
</html>