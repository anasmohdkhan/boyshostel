<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Students</title>
</head>
<body>

	<div id="main">

		<div class="box">
			<div style="width:200px; height:400px;float:left;">
				<c:import url="home.jsp" />
			</div>
			<div style="width:1000px; height: 800px;position:relative; left:250px;">
				<table class="table table-responsive menu-table" style="position:absolute;top:120px;">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Phone</th>
							<th>Address</th>
							<th>Email</th>
							<th>Password</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${listUsers}" var="listUsers">
							<c:url var="updateLink" value="/updatestudent">
								<c:param name="userId" value="${listUsers.userId}" />
							</c:url>

							<c:url var="deleteLink" value="/delete">
								<c:param name="userId" value="${listUsers.userId}" />
							</c:url>

							<tr>
								<td><label>${listUsers.userId}</label></td>
								<td><label>${listUsers.userName}</label></td>
								<td><label>${listUsers.contactNo}</label></td>
								<td><label>${listUsers.address}</label></td>
								<td><label>${listUsers.email}</label></td>
								<td><label>${listUsers.password}</label></td>
								<td><label><a href="${updateLink}">Update</a> | <a
										href="${deleteLink}" onclick="myFunction()">Delete</a> <script>
											function myFunction() {
												confirm("confirm(Are you sure you want to delete this user)");
											}
										</script></label></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<br />
	<div class="clear"></div>

</body>

</html>