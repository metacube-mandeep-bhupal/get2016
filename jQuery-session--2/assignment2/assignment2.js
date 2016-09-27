$(document).ready(action);


function action() {
    $('#employeeName').change(getDetails);
}

function getDetails() {
    $.getJSON('assignment2.json',display);
}

function display(data) {
	$('.infoDiv').css("display", "block");
    switch($('#employeeName').val()) {
        case "Vivek" :
            $('#name').text(data.Vivek.Name);
            $('#email').text(data.Vivek.Email);
            $('#dob').text(data.Vivek.DOB);
            $('#address').text(data.Vivek.Address);
            break;
        case "Rahul" :
            $('#name').text(data.Rahul.Name);
            $('#email').text(data.Rahul.Email);
            $('#dob').text(data.Rahul.DOB);
            $('#address').text(data.Rahul.Address);
            break;
        case "Anshu" :
            $('#name').text(data.Anshu.Name);
            $('#email').text(data.Anshu.Email);
            $('#dob').text(data.Anshu.DOB);
            $('#address').text(data.Anshu.Address);
            break;
        case "Shashi" :
            $('#name').text(data.Shashi.Name);
            $('#email').text(data.Shashi.Email);
            $('#dob').text(data.Shashi.DOB);
            $('#address').text(data.Shashi.Address);
            break;
        default :
        	$('.infoDiv').css("display", "none");
    }
}
