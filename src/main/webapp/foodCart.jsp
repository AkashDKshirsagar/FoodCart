<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" isELIgnored="false"%>
<%@ page import="com.akash.dao.FoodDAO"%>
<%@ page import="com.akash.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Card</title>
</head>
<body>
	<center>
		<h1>Menu Card</h1>
		<div align="center">
			<table border="1" cellpadding="5">
				<tr>
					<th>Code</th>
					<th>Item</th>
					<th>Price</th>

				</tr>
				<c:forEach items="${foodItems}" var="u">
					<tr>
						<td>${u.getCode()}</td>
						<td>${u.getItem()}</td>
						<td>${u.getPrice()}</td>

					</tr>
				</c:forEach>
				</div>
			</table>
	</center>
</body>
</html>