<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
.header{
padding-top:300px;
height:100px;
width:100%;
}

.main{
height: 500px;
width: 100%;
}

.block {
  display: inline-block;
  width: 24%;
  height: 100%;
  border: none;
  background-color: #3f8830;
  color: white;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
  text-align: center;
}

.btns{
padding-left:60px;
left:10px;
width:97%;
height:200px;
}
</style>

</head>
<body>
<div class= "header">
<div class="btns">
<button class="block"><a href="doctorRegister">Add Doctor</a></button>
<button class="block"><a href="viewAppointment">View Appointments</a></button>
<button class="block"><a href="addMedicine">Add Medicine</a></button>
<button class="block"><a href="addTest">Add Pathology Test</a></button>
</div>
</div>



</body>
</html>