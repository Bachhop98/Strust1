<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/t001.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<header>
		<div class="header">
			<h2>Training</h2>
		</div>
	</header>
	<section>
		<nav>
			<p class="breadcrumb">Login</p>
		</nav>

		<article>
			<div class="form-login">
				<div class="form-title">
					<div class="form-name">LOGIN</div>
					<div class="form-error">Error</div>
				</div>
				<div class="form-data">
					<html:form action="T001.do" method="post">
						<div class="col">
							<div class="row">
								<label>User Id:</label>
							</div>
							<div class="row">
								<label>Password:</label>
							</div>
						</div>
						<div class="col">
							<div class="row">
								<html:text property="userId" name="t001Form" styleClass="txt-username"></html:text>
							</div>

							<div class="row">
								<html:password property="password" styleClass="txt-password"
									name="t001Form"></html:password>
							</div>

						</div>
						<div class="btn">
							<div class="btn-login">
								<html:submit styleClass="btn-login-style" >Login</html:submit>
							</div>
							<div class="btn-reset">
								<html:button property="btn-reset" styleClass="btn-reset-style">Reset</html:button>
							</div>
						</div>
					</html:form>
				</div>

			</div>

		</article>
	</section>

	<footer>
		<div class="footer">
			<h5>Copyright (c) 2000-2008 FUJINET, All Rights Reserved</h5>
		</div>
	</footer>
</body>
</html>