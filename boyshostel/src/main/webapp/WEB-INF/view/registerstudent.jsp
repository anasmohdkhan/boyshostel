<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Student</title>
</head>
<body>
	<div class="container">
		<div style="float: left; width: 300px">
			<c:import url="home.jsp" />
		</div>

		<div class="row" style="margin-top: 20px; width: 800px;">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">

				<form:form action="save" modelAttribute="userDetails" method="post" role="form">

					<fieldset>

						<h2>Register New Student</h2>

						<hr class="colorgraph">
						
						<div class="form-group">
							<form:input type="text" name="userName" id="userName"
								class="form-control input-lg" path="userName" placeholder="userName" />
						</div>
						<div class="form-group">
							<form:input type="text" name="contactNo" id="contactNo"
								class="form-control input-lg" path="contactNo" placeholder="contactNo" />
						</div>
						<div class="form-group">
							<form:input type="text" name="address" id="address"
								class="form-control input-lg" path="address" placeholder="address" />
						</div>
						<div class="form-group">
							<form:input type="text" name="email" id="email"
								class="form-control input-lg" path="email" placeholder="email" />
						</div>
						<div class="form-group">
							<form:input type="password" name="password" id="password"
								class="form-control input-lg" path="password" placeholder="password" />
						</div>
						<%-- <div class="form-group">
									<form:input type="text" name="courseName" id="courseName"
										class="form-control input-lg" path="courseName" />
								</div>
								<div class="form-group">
									<form:input type="text" name="courseDuration"
										id="courseDuration" class="form-control input-lg"
										path="courseDuration" />
								</div> --%>
						<hr class="colorgraph">
						<div class="row">

							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<input type="submit" class="btn btn-lg btn-success btn-block"
										value="Register">

								</div>
							</div>
						</div>
					</fieldset>

				</form:form>
			</div>
		</div>

	</div>



</body>
</html>