<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<link rel="stylesheet" href="index.css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
</head>
<body>
		<header id="header"> Update Car <br /> </header>
		<hr />
		
		<div id="form_box">
		<form action="UpdateCar" method="GET">
				<div class="form_box_row">
					<div class="left_field">
						Company Name:
					</div>
					<div class="right_field">
					<input value="<%= request.getParameter("companyName") %>" placeholder="Comapny Name" name="companyName" type="text" required class="inside_input" pattern="[A-Z a-z]{3,}" />
					</div>
				</div>
				
				<div class="form_box_row">
					<div class="left_field">
						Model 
					</div>
					<div class="right_field"> 
							<input value="<%= request.getParameter("modalNumber") %>" placeholder="Madel " name="Model" type="text" required class="inside_input" />
					</div>
				</div>
				
				<div class="form_box_row">
					<div class="left_field">
						Fuel Capacity(in liters)
					</div>
					<div class="right_field">  
							<input value="<%= request.getParameter("fuelCapacity") %>" placeholder="Fuel Capacity" name="FuelCapacity" type="number" required class="inside_input"  />
					</div>
				</div>
					<div class="form_box_row">
					<div class="left_field">
						Engine In CC
					</div>
					<div class="right_field">  
							<input value="<%= request.getParameter("engineInCC") %>" placeholder="Engine in CC" name="EngineInCC" type="number" required class="inside_input"  />
					</div>
				</div>
				
				<div class="form_box_row">
					<div class="left_field">
						Mileage
					</div>
					<div class="right_field"> 
						<input value="<%= request.getParameter("mileage") %>" placeholder="Milage" name="milage" type="number" required class="inside_input" />
					</div>
				</div>
				
				<div class="form_box_row">
					<div class="left_field">
						Price
					</div>
					<div class="right_field">
							 <input value="<%= request.getParameter("price") %>" placeholder="Price" name="price" type="number" required class="inside_input" />
					</div>
				</div>
				
				<div class="form_box_row">
					<div class="left_field">
						Road Tax
					</div>
					<div class="right_field">
						<input value="<%= request.getParameter("roadTax") %>" placeholder="Road Tax" name="RoadTax" type="number" required class="inside_input" />
					</div>
				</div>
				<% 
					String notChecked= "";
					String checked = "";
				if( Integer.parseInt(request.getParameter("AC")) == 0){
					checked = "checked" ;	
				}  else{
					notChecked = "checked";
				}%>
				
				<div class="form_box_row">
					<div class="left_field">
						AC ?
					</div>
					<div class="right_field radio_button" >
							
								<input name="AC" value="Yes" type="radio"  class="radio_box" <%= checked %> />Yes
								<input name="AC" type="radio" value="No"  class="radio_box" <%= notChecked %>  /> No
					</div>
				</div>
				<% 
					 notChecked= "";
					 checked = "";
				if( Integer.parseInt(request.getParameter("powerSteering")) == 0){
					checked = "checked" ;	
				}  else{
					notChecked = "checked";
				}%>
				<div class="form_box_row">
					<div class="left_field">
						Power Steering ?
					</div>
					<div class="right_field radio_button" >
							
								<input value="Yes" name="PowerStreering" type="radio"  class="radio_box" <%= checked %> />Yes
								<input  value="No" name="PowerStreering" type="radio"  class="radio_box" <%=notChecked %> />No
					</div>
				</div>
				<% 
					 notChecked= "";
					 checked = "";
				if( Integer.parseInt(request.getParameter("accessoryKit")) == 0){
					checked = "checked" ;	
				}  else{
					notChecked = "checked";
				}%>
				<div class="form_box_row">
					<div class="left_field">
						Accessory kit ?
					</div>
					<div class="right_field radio_button" >
								<input  name="AccessoryKit" value="Yes" type="radio"  class="radio_box" <%= checked %> /> Yes
								<input  name="AccessoryKit" value ="No" type="radio"  class="radio_box" <%= notChecked %> /> No
					</div>
				</div>
				<input type="hidden" name="id" value="<%= request.getParameter("id")  %>">
				<div class="form_box_row">
					<div id="submit_box">
						<button type="submit" id="submit_field">Send <i class="fa fa-paper-plane" aria-hidden="true"></i> </button>
					</div>
				</div>
				
				</form>
				</div>	
	
</body>
</html>