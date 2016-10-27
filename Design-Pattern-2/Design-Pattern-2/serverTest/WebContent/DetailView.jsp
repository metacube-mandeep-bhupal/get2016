<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header id="header"> Update Car <br /> </header>
		<hr />
		<table>
			<tr>
				<td> Company Name </td>
				<td> <%= request.getParameter("companyName") %> </td>
			</tr>
			<tr>
				<td> Model </td>
				<td> <%= request.getParameter("modalNumber") %> </td>
			</tr>
			<tr>
				<td> Fuel Capacity </td>
				<td> <%= request.getParameter("fuelCapacity") %> </td>
			</tr>
			<tr>
				<td> Engine In CC </td>
				<td> <%= request.getParameter("engineInCC") %> </td>
			</tr>
			<tr>
				<td> Mileage </td>
				<td> <%= request.getParameter("mileage") %> </td>
			</tr>
			<tr>
				<td> Price </td>
				<td> <%= request.getParameter("Price") %> </td>
			</tr>
			<tr>
				<td> Road Tax </td>
				<td> <%= request.getParameter("roadTax") %> </td>
			</tr>
				<% String powerSteering = "No"; %>
				<% String ac = "No"; %>
				<% String accessoryKit = "No"; %>
				<%
					if(Integer.parseInt(request.getParameter("AC")) == 1){
						ac = "Yes";
					}
					if(Integer.parseInt(request.getParameter("powerSteering") ) == 1){
						powerSteering = "Yes";
					}
					if(Integer.parseInt(request.getParameter("accessoryKit") ) == 1){
						accessoryKit = "Yes";
					}
				
				%>
			<tr>
				<td> Power Steering </td>
				<td> <%= powerSteering %> </td>
			</tr>
			<tr>
				<td> AC </td>
				<td> <%= ac %> </td>
			</tr>
			<tr>
				<td> Accessory Kit </td>
				<td> <%= accessoryKit %> </td>
			</tr>
		</table>
</body>
</html>