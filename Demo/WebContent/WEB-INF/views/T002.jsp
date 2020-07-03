<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html>
<html>
<head>
<title>Search Customer</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/t002.css">
</head>
<body>
<body>
	<header>
		<div class="header">
			<h2>Training</h2>
		</div>
	</header>
	<section>

		<ul class="breadcrumb">
			<li><a href="#">Login</a></li>
			<li>Search Customer</li>
		</ul>

		<div class="content">
			<div class="row">
				<label class="txt-username">Wellcom, </label> <label class="logout"><a
					href="#">Logout</a></label>
			</div>
			<html:form action="T002.do" method="post">

				<div class="div_search">
					<div class="lb-customer-name">
						<label>Customer Name</label>
					</div>
					<div class="txt-customer-name">
						<html:text property="customerName" name="t002Form"></html:text>
					</div>
					<div class="n-sex">
						<label class="col">Sex:</label>
						<html:select property="sex" name="t002Form" styleClass="col">
							<html:option value=""></html:option>
							<html:option value="0">Male</html:option>
							<html:option value="1">Female</html:option>
						</html:select>
					</div>

					<div class="n-birthday">
						<label>Birth Day</label> <input type="date" id="start"
							name="trip-start" value="" min="1900-01-01" max="2100-12-31">
						<label>~</label> <input type="date" id="start" name="trip-start"
							value=" " min="1900-01-01" max="2100-12-31">

					</div>
					<div>
						<html:submit property="action" value="Search"
							styleClass="n-search"></html:submit>
					</div>
				</div>
				<div class="btn-group">
					<div class="btn-group-left">
						<html:submit property="action" value="first" styleClass="button"></html:submit>
						<html:submit property="action" value="pre" styleClass="button"></html:submit>
					</div>
					<div class="btn-group-right">
						<html:submit property="action" value="next" styleClass="button"></html:submit>
						<html:submit property="action" value="last" styleClass="button"></html:submit>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th><input type="checkbox" id="vehicle1" name="vehicle1"
								value="Bike"></th>
							<th>CustomerId</th>
							<th>CustomerName</th>
							<th>Sex</th>
							<th>BirthDay</th>
							<th>Address</th>
						</tr>
					</thead>
					<tbody>
						<html:hidden property="page" name="t002Form" />
						<logic:iterate name="t002Form" property="listCustomer"
							id="customer">
							<tr>
								<td><input type="checkbox" id="vehicle1" name="vehicle1"
									value="Bike"></td>
								<td scope="row"><a
									href="http://localhost:8080/Demo/T003.do?id=<bean:write name="customer" property="id" />">
										<bean:write name="customer" property="id" />
								</a></td>

								<td><bean:write name="customer" property="name" /></td>
								<td><logic:equal name="customer" property="sex" value="0">
								male
							</logic:equal> <logic:equal name="customer" property="sex" value="1">
								female
							</logic:equal></td>
								<td><bean:write name="customer" property="birthDay" /></td>
								<td><bean:write name="customer" property="address" /></td>

							</tr>
						</logic:iterate>
					</tbody>
				</table>
				<div class="btn-event">
					<div class="btn-group-add">
						<html:button property="add" value="Add New" styleClass="btn-add"></html:button>
					</div>
					<div class="btn-group-delete">
						<html:submit property="action" value="Delete"
							styleClass="btn-delete"></html:submit>
					</div>
				</div>

			</html:form>
		</div>
	</section>
	<footer>
		<div class="footer">
			<p>Copyright (c) 2000-2008 FUJINET, All Rights Reserved
			<p>
		</div>
	</footer>

</body>
</html>