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

<h2 align="center">Enter Patient Details to Register</h2>

<div>
  <form action="savePatient" method="POST">

    <label for="fname">First Name</label><br>
    <input type="text" id="fname" name="first_name" placeholder="First Name.." ><br>

    <label for="lname">Last Name</label><br>
    <input type="text" id="lname" name="last_name" placeholder="Last Name.." ><br>

    <label for="age">Age</label><br>
    <input type="number" id="age" name="age" placeholder="Age.." ><br>

    <label for="problem">Problem</label><br>
        <select id="problem" name="problem">
          <option value="Fever">Fever</option>
          <option value="Headache">Headache</option>
        </select><br>

    <label for="doctor_id">Select Doctor</label><br>
         <select id="doctor_id" name="doctor_id">
           <option value="1">Saurav Suman (Fever)</option>
           <option value="2">Sristi Shreya (Headache)</option>
         </select><br>

    <label for="fees">Fee</label><br>
    <input type="number" id="fees" name="fees" placeholder="Fee.." ><br>
    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>