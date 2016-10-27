<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Cars</title>
</head>
<body>
<% 
	CarFacade carFacade = new CarFacade();
	List<CarValueObject> list;
	list = carFacade.getCars();
	%>
<table>
	<tr>
		<th> Company </th>
		<th> Model </th>
		<th> Engine(CC) </th>
		<th> Fuel Capacity </th>
		<th> Milage </th>
		<th> Price </th>
		<th> Road Tax </th>
		<th> Toatl Price </th>
		<th> Power Steering? </th>
		<th> Accessory Kit? </th>
		<th> AC? </th>
	</tr>
	<% for(CarValueObject cvo : list){%>
	<% String powerSteering = "No"; %>
	<% String ac = "No"; %>
	<% String accessoryKit = "No"; %>
		<% if(cvo.getIsPowerSteering() == 1) {  powerSteering = "Yes"; } %>
		<% if(cvo.getIsAccessoryKit() == 1) {  accessoryKit = "Yes"; } %>
		<% if(cvo.getIsAC() == 1) {  ac = "Yes"; } %>
		<tr>
		<td> <%= cvo.getComapny() %> </td>
		<td> <%= cvo.getModel() %> </td>
		<td> <%= cvo.getEngineInCC() %> </td>
		<td> <%= cvo.getFuelCapacity() %> </td>
		<td> <%= cvo.getMileage() %></td>
		<td> <%= cvo.getPrice() %> </td>
		<td> <%= cvo.getRoadTax() %> </td>
		<td> <%= cvo.getPrice()+cvo.getRoadTax() %> </td>
		
		
		<td> <%= powerSteering %></td>
		<td> <%= accessoryKit  %></td>
		<td> <%= ac %> </td>
		<td> <a href="UpdateCar.jsp?id=<%=cvo.getID() %>&companyName=<%= cvo.getComapny() %>&
			modalNumber=<%=cvo.getModel()%>&engineInCC=<%= cvo.getEngineInCC() %>&fuelCapacity=
			<%=cvo.getFuelCapacity()%>&mileage=<%=cvo.getMileage()%>&price=<%=cvo.getPrice()%>&
			roadTax=<%=cvo.getRoadTax()%>&AC=<%=cvo.getIsAC()%>&
			powerSteering=<%=cvo.getIsPowerSteering()%>
			&accessoryKit=<%=cvo.getIsAccessoryKit()%>"> Edit </a> </td>

			<td><a href="DetailView.jsp?id=<%=cvo.getID() %>&companyName=<%= cvo.getComapny() %>&
			modalNumber=<%=cvo.getModel()%>&engineInCC=<%= cvo.getEngineInCC()%>&fuelCapacity=
			<%=cvo.getFuelCapacity()%>&mileage=<%=cvo.getMileage()%>&price=<%=cvo.getPrice()%>&
			roadTax=<%=cvo.getRoadTax()%>&AC=<%=cvo.getIsAC()%>&
			powerSteering=<%=cvo.getIsPowerSteering()%>
			&accessoryKit=<%=cvo.getIsAccessoryKit()%>"> Detailed View </a> </td>
		</tr>
		
	<% } %>
	
</table>

<br />
<br />
<a href="index.html" >Home</a>
</body>
</html>