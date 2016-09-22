$(document).ready(function() {
    
    $("#button1").click(function() {
        $("#grandParent1").parent().css("border-color", "blue");
    });
    
    $("#button2").click(function() {
        $("#directParent1").parentsUntil("body").css("border", "10px solid red");
    });
    
    $("#button3").click(function() {
        $("#directParent1").closest("div").css("border", "10px solid yellow");
    });

    $("#button4").click(function() {
        $("#grandParent1").siblings().css("border", "10px solid white");
    });
    
});
