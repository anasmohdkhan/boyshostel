<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
.formWrap {
	width: 400px;
	height: 500px;
	margin-left: auto;
	margin-right: auto;
	padding:30px;
}
.loginForm{
		background:white;
		
		
}
.loginForm input{
	margin-left:30px;
	height:20px;
	    border: 1px solid #dfe1e5;
	    box-shadow:0 1px 6px 0 rgba(32,33,36,0.28);
	
}
.loginForm input:hover{
   border:1px solid green;
}
</style>
</head>
<body>
	<div class="formWrap">
		<center>
		<h2>Please Login</h2>
		
		</center>
		
		<form:form action="checkAuthentication" modelAttribute="userDetails" method="get" class="loginForm">
			<table>
			<tr>
			    <td> Email :</td>
			    <td><form:input type="text" path ="email" name="email"/></td>
			 </tr>
			<tr>
				 <td>Password :</td>
			     <td><form:input type="password" path ="password" name="password"/></td>
			</tr>
			<tr>
			   <td></td><td><input type="submit" value="submit"><input type="reset" value="reset"></td>
			</tr>
			
			</table>
		</form:form>


	</div>

</body>
</html>