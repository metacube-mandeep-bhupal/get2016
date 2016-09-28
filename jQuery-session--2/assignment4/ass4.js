$(document).ready(writeInfo);

function writeInfo(){
	$("#name").keyup(displayName);
	$("#age").keyup(displayAge);
	$("#address").keyup(displayAddress);
}

function displayName(){
	var value = document.getElementById('name').value;
	value="Name : "+value;
	$(".data").text(value);
	$("#name").css("background-color", "burlywood");
	setTimeout(function(){ $("#name").css("background-color", "white"); },200);
}

function displayAge(){
	var value = document.getElementById('age').value;
	if (!$.isNumeric(value) || value > 1000){
		alert("Invalid Age");
	}else{
		value="Age : "+value;
		$(".data").text(value);
		$("#age").css("background-color", "burlywood");
		setTimeout(function(){ $("#age").css("background-color", "white"); },200);
	}
}

function displayAddress(){
	var value = document.getElementById('address').value;
	value="Address : "+value;
	$(".data").text(value);
	$("#address").css("background-color", "burlywood");
	setTimeout(function(){ $("#address").css("background-color", "white"); },200);
}
