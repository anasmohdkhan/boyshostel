<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Student</title>
</head>
<body>
		<h1>
		View<span class="gray">Profile</span>
	</h1>
	<hr color="lightblue">
	<br>
	<div style="width : 400px ; height:400px ; float: left">
	<c:import url="home.jsp" />
	</div>
	<div style="width : 400px ; height:400px ; margin-left:auto; margin-right:auto">
	<form action="UpdateStudentController" method="post">

		<table>
			<tr>
				<th>Name:</th>
				<td><input type="text" name="userName" id="userName"
					class="form-control input-lg" value="${userDetails.getUserName()}"></td>
			</tr>
			<tr>
				<th>Contact No.:</th>
				<td><input type="text" name="contactNo" id="contactNo"
					class="form-control input-lg" value="${userDetails.getContactNo()}"></td>
			</tr>
			
			<tr>
				<th>Address.:</th>
				<td><input type="text" name="address" id="address"
					class="form-control input-lg" value="${userDetails.getAddress()}"></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="text" name="email" id="email"
					class="form-control input-lg" value="${userDetails.getEmail()}"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="text" name="password" id="password"
					class="form-control input-lg" value="${userDetails.getPassword()}"></td>
			</tr>
			
			<tr>
				<th>Course Name:</th>
				<td><input type="text" name="userPhone" id="userPhone"
					class="form-control input-lg" value="course name"></td>
			</tr>
			
			<tr>
				<th>Course Duration:</th>
				<td><input type="text" name="userPhone" id="userPhone"
					class="form-control input-lg" value="course duration"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="hidden" name="userId"
					value="${userDetails.getUserId()}"></td>
			</tr>
		</table>

		<input type="submit" value="Update">
	</form>
	</div>
</body>
</html>