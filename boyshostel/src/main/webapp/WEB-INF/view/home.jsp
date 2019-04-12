<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1>
		Welcome
		<c:out value="${sessionScope.userDetails.getUserName()}" />
	</h1>

	<c:if test="${userDetails!=null && userDetails.getUserId()<1}">
1. <a href="${pageContext.request.contextPath}/${registerstudent}">register
			student</a>
		<br>
2. <a href="visitorentry.jsp">visitor entry</a>
		<br>
3. <a href="addroom.jsp">add room</a>
		<br>
4. <a href="addfee.jsp">add fees</a>
		<br>
5. <a href="allotroom.jsp">allot room</a>
		<br>
6. <a href="${pageContext.request.contextPath}/${viewallstudents}">view all students</a>
		<br>
7. <a href="ViewAllRoomController">view all rooms</a>
		<br>
8. <a href="AllAllotedRoomController">view all alloted rooms</a>
		<br>
9. <a href="AllReportsController">vew all reports</a>
		<br>
10. <a href="AllVisitorController">vew all visitor</a>
		<br>
11. <a href="LogoutController">logout</a>
		<br>
	</c:if>

	<c:if test="${userDetails!=null && userDetails.getUserId()>0}">

		<c:url var="updateLink"
			value="/updatestudent">
			<c:param name="userId" value="${userDetails.getUserId()}" />
		</c:url>


1. <a href="${updateLink}">Update</a>
		<br>
2. <a href="borrowBooks.jsp">Search By Name</a>
		<br>
3. <a href="viewProfile.jsp">Search By Room No.</a>
		<br>
4. <a href="updateUserDetails.jsp">Update Profile</a>
		<br>
5. <a href="returnBook.jsp">View Report</a>
		<br>
6. <a href="LogoutController">logout</a>
		<br>
	</c:if>

</body>
</html>