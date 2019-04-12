<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<div class="container">

		<div class="row" style="margin-top: 20px">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form:form action="save" modelAttribute="userDetails" method="post" role="form">
					<fieldset>
						<h2>User Register Form</h2>
						<div class="form-group">
							<form:input type="text" name="userName" id="userName"
								class="form-control input-lg" path="userName" placeholder="Name"/>
						</div>
						<div class="form-group">
							<form:input type="text" name="contactNo" id="contactNo"
								class="form-control input-lg" path="contactNo" placeholder="Contact Number"/>
						</div>
						<div class="form-group">
							<form:input type="text" name="address" id="address"
								class="form-control input-lg" path="address" placeholder="Address"/>
						</div>
						<div class="form-group">
							<form:input type="text" name="email" id="email"
								class="form-control input-lg" path="email" placeholder="Email"/>
						</div>
						<div class="form-group">
							<form:input type="password" name="password" id="password"
								class="form-control input-lg" path="password" placeholder="Password"/>
						</div>

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