<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Customer</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/t003.css">
</head>
<body>
	<header>
		<div class="header">
			<h2>Training</h2>
		</div>
	</header>
	<section>

		<ul class="breadcrumb">
			<li><a href="#">Login</a></li>
			<li><a href="#">Search Customer</a></li>
			<li>Edit Customer</li>
		</ul>
		<html:form action="T003.do" method="post">
			<html:text property="id" name="t002Form"></html:text>
			<html:text property="name" name="t002Form"></html:text>
			<html:text property="sex" name="t002Form"></html:text>
			<html:text property="birthDay" name="t002Form"></html:text>
			<html:text property="email" name="t002Form"></html:text>
			<html:text property="address" name="t002Form"></html:text>
		</html:form>
	</section>
</body>
</html>