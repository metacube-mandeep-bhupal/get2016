$(document).ready(manager);
    
function manager(){
    $("#startButton").click(start);
    $("#stopButton").click(stop);
    $("#backButton").click(back);
    $("#leftButton").click(left);
    $("#rightButton").click(right);
    $("#topButton").click(tops);
    $("#bottomButton").click(bottoms);
}

function start(){
    $("#block").animate({left: '+=1000px'},3000);
}

function stop(){
    $("#block").stop();
}

function back(){
    $("#block").animate({left: '-=1000px'},3000);
}

function left(){
    $("#block").animate({left: '-=50px'});
}

function right(){
    $("#block").animate({left: '+=50px'});
}

function tops(){
    $("#block").animate({top: '-=50px'});
}

function bottoms(){
    $("#block").animate({top: '+=50px'});
}
