$(document).ready(function(){
    $("#button1").click(function(){
        $("span.message").css("background-color", "burlywood");
    });
    $("#button2").click(function(){
        $("div:").css("background-color", "blue");
    });
    $("#button3").click(function(){
        $("* #buttons").css("background-color", "green");
    }); 
    $("#button4").click(function(){
        $("img[alt='hello']").css("background-color", "orange");
    }); 
    $("#button5").click(function(){
        $("#myDiv input[type=text]").val("Observe the Changed Text");      
    });
    $("#button6").click(function(){
        $("input[name^='txt']").val("Observe change");
    }); 
    $("#button7").click(function(){
        $(" :not(.box)p").css("background-color", "darkgray");
    }); 
    $("#button8").click(function(){
        $("div.box,div.error").css("background-color", "burlywood");
    }); 
    $("#button9").click(function(){
        $("div.box.error").css("background-color", "yellow");
    }); 
    $("#button10").click(function(){
        $("#myDiv span.info").css("background-color", "pink");
    }); 
});
