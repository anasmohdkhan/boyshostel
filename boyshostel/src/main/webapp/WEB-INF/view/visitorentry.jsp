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
	<div class="container">
		<div style="float: left; width: 300px">
			<c:import url="home.jsp" />
		</div>

		<div class="row" style="margin-top: 20px; width: 800px;">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form action="VisitorController" method="post" role="form">
					<fieldset>
						<h2>Register Visitor</h2>
						<hr class="colorgraph">

						<div class="form-group">
							<input type="text" name="visitorName" id="visitorName"
								class="form-control input-lg" placeholder="Visitor Name">
						</div>
						<div class="form-group">
							<input type="text" name="visitorContactNo" id="visitorContactNo"
								class="form-control input-lg" placeholder="Contact Number">
						</div>
						<div class="form-group">
							<input type="text" name="studentName" id="studentName"
								class="form-control input-lg" placeholder="Whom to meet">
						</div>
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
				</form>
			</div>
		</div>

	</div>



</body>
</html>