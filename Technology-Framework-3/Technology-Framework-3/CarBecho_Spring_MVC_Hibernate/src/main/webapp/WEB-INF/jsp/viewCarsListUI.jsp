<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.Metacube.service.CarServiceImpl"%>
<%@page import="com.Metacube.factory.ServiceFactory"%>
<%@page import="com.Metacube.model.CarVO"%>
<%@page import="java.util.*;"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      

<html>
<head>
<title>View Cars</title>
</head>
<body>
	<h2>Cars List</h2>
	<table>
		<tr>
			<th>Company</th>
			<th>Model</th>
			<th>On Road Price</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="car" items="${list}">
			<tr>
				<td>${car.companyName}</td>
				<td>${car.modelName}</td>
				<td>${car.onRoadPrice}</td>
				<td><a href="/CarBecho_Spring_MVC_Hibernate/findcar/${car.companyName}/${car.modelName}">Details</a></td>
				<td><a href="/CarBecho_Spring_MVC_Hibernate/updateCar/${car.companyName}/${car.modelName}">Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>