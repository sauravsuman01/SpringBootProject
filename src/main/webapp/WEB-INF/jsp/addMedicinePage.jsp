<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=number], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<body>

<h2 align="center">Enter Medicine Details</h2>

<div>
  <form action="saveMedicine" method="POST">

    <label for="medicineId">Medicine Id</label><br>
    <input type="number" id="medicineId" name="medicineId" placeholder="Medicine Id.." ><br>

    <label for="medicineName">Medicine Name</label><br>
    <input type="text" id="medicineName" name="medicineName" placeholder="Medicine Name.." ><br>

    <label for="medicinePrice">Medicine Price</label><br>
    <input type="number" id="medicinePrice" name="medicinePrice" placeholder="Medicine Price.." ><br>

    <label for="medicineStock">Stock Count</label><br>
    <input type="number" id="medicineStock" name="medicineStock" placeholder="Medicine Stock.." ><br>
    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>